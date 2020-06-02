package criptografia;

import java.util.Scanner;

public class JulioCesarTest {
	public static void main(String[] args) {
		
		JulioCesar test = new JulioCesar();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Digite sua frase secreta:\n");
		test.setPhrase(scanner.nextLine());
		System.out.println("Digite sua chave de criptografia:\n");
		test.setCode(scanner.nextInt());
		
		test.cripto();
		test.showPhrase();
	}
}
