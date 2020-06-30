package criptografia;

import java.util.Scanner;

public class JulioCesar {
	private char word;
	private int lengh, code = 0;
	private String phrase;
	private String unreadablePhrase;
	Scanner scanner = new Scanner(System.in);

	public void cripto() {
		lengh = phrase.length();
		for(int i = 0; i < lengh; i++) {
			word = phrase.charAt(i);
			// verificando se é um caractere de alfabeto
			if (((word >= 'A') && (word <= 'W')) ||
					((word >= 'a') && (word <= 'w'))) {
				word += getCode();
				unreadablePhrase = String.valueOf(word);
			}
			else if(((word >= 'X') && (word <= 'Z')) ||
					((word >= 'x') && (word <= 'z'))) {
				word -=26 - getCode();
				unreadablePhrase = String.valueOf(word);
			}
			else if(Character.isSpaceChar(word)) {				
				unreadablePhrase = String.valueOf(word);
			}
			else if((word >= '0') && (word <= '9')) {				
				unreadablePhrase = String.valueOf(word);
			}
			unreadablePhrase = String.valueOf(word);
			System.out.printf(unreadablePhrase.toLowerCase());
		}
	}
	
	public void showPhrase() {
		System.out.println("\n\n");
		System.out.println("Deseja ver a frase original?\nSe sim, digite: 1\nNão, digite 2");
		int index = scanner.nextInt();
		if(index ==2) return;
		System.out.printf(phrase.toLowerCase());
	}
	
	

	public String getPhrase() {
		return phrase;
	}
	public void setPhrase(String phrase) {
		this.phrase = phrase;
	}
	public int getCode() {
		while(this.code >= 26) {//limitando o conjunto alfabet
			this.code = code - 26;
		}
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
}
