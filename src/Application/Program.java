package Application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import Entities.ImportedProduct;
import Entities.Product;
import Entities.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Enter the number of products: ");
		int number = sc.nextInt();
		
		List<Product> list = new ArrayList<>();
		
		for(int i =1;i<=number; i++) {
			System.out.println("Product #" + i + " data:");
			System.out.printf("Commom, used or imported (c/u/i)? ");
			char resp = sc.next().charAt(0);
			sc.nextLine();
			System.out.print("Name: ");
			String name = sc.nextLine();
			System.out.print("Price: ");
			double price = sc.nextDouble();
			
			if(resp == 'c') {
				Product product = new Product(name, price);
				list.add(product);
				//list.add(new Product(name, price));
			}
			else if (resp == 'u') {
				System.out.printf("Manufacture date (DD/MM/YYYY): ");
				Date date = sdf2.parse(sc.next());
				UsedProduct usedProduct = new UsedProduct(name, price, date);
				list.add(usedProduct);
			}
			else {
			System.out.print("Customs fee: ");
			double customs = sc.nextDouble();
			ImportedProduct importedProduct = new ImportedProduct(name, price, customs);
			list.add(importedProduct);
			
			}
		}
		System.out.println();
		System.out.println("PRICE TAGS: ");
		for(Product p: list) {
			System.out.println(p.priceTag());
		}

		sc.close();

	}

}
