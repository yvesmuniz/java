package com.wp.mballem.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.Scanner;

public class HtmlParserFooter  {
    private Document document;
    private static Double dolar;
   
    public HtmlParserFooter(Document document) {
        this.document = document;
    }

    HtmlParserFooter() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void starter(){
        
            
            boolean loop = true;
            
            
        try {
           // Document document = Jsoup.connect("https://br.investing.com/currencies/").get();
           // HtmlParserFooter parserFooter = new HtmlParserFooter(document);
           // parserFooter.getParameters();
            Scanner sc = new Scanner(System.in);
            ReadData rd = new ReadData();
            System.out.println("Taxa de juros doméstica: ");
            System.out.println();
            rd.setI(sc.nextDouble());
            System.out.println("Taxa de juros no país estrangeiro: ");
            rd.setJ(sc.nextDouble());
            System.out.println("Períodos até o vencimento do contrato futuro: ");
            rd.setN(sc.nextDouble());
            System.out.println("Base de tempo para taxa de juros doméstica: ");
            rd.setM(sc.nextDouble());
            System.out.println("Base de tempo para taxa de juros país estrangeiro: ");
            rd.setP(sc.nextDouble());
            
            
            while(loop){
                
                Document document = Jsoup.connect("https://br.investing.com/currencies/").get();
                HtmlParserFooter parser = new HtmlParserFooter(document);
                parser.getDate(rd);
                
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private void getDate(ReadData rd) {
     
        Element element = document.getElementById("TSB__summary_last_2103");
        StringBuilder str = new StringBuilder(element.text());

        Double valor = Double.valueOf(String.valueOf(str.deleteCharAt(1)));
        Double dolar = valor / 10000;
        System.out.println("Preço atual do dolar: "+dolar);
        
        double result, r1, r2, p1, p2;
        r1 = rd.getN() / rd.getM();
        r2 = rd.getN() / rd.getP();
                
        result = dolar * (Math.pow((1 + rd.getI()), r1)) / (Math.pow((1 + rd.getJ()), r2));
        System.out.println("Resultado: "+result);
        
    }

    

}
