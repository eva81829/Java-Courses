/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productmanagesystem;

import java.util.Scanner;

/**
 *
 * @author Eka
 */

public class ProductManageSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scanner = new Scanner(System.in);
        Warehouse warehouse = new Warehouse();
        Product product;
        String name;
        String category;
        String tag;
        int amount;
        int price;
        
        int opt;
        do {
            System.out.print("請輸入選項(1~8):");
            opt = scanner.nextInt();
            scanner.nextLine(); 
            if (opt==8){
                break;
            } else if(opt>8 || opt<1){
                continue;
            }
            
            switch(opt){
                case 1:
                    boolean keepAdd = true;
                    do {
                        System.out.print("請輸入商品名稱:");
                        name = scanner.nextLine();
                        System.out.print("請輸入商品價格:");
                        price = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("請輸入商品分類:");
                        category = scanner.nextLine();
                        System.out.print("請輸入商品數量:");
                        amount = scanner.nextInt();
                        scanner.nextLine();
                        
                        Product.Builder builder = new Product.Builder(name, price, category, amount);

                        System.out.print("請新增標籤(若不新增請輸入N):");
                        tag = scanner.nextLine();
                        builder.setTag(tag);

                        System.out.print("請新增第二分類(若不新增請輸入N):");
                        String secCategory = scanner.nextLine();
                        builder.setSecCategory(secCategory);

                        product = builder.gen();

                        keepAdd = warehouse.setProduct(product);
                    }  while (!keepAdd);
                    break;
                    
                case 2:
                    System.out.print("請輸入商品名稱:");
                    name = scanner.nextLine();
                    System.out.print("請輸入商品數量:");
                    amount = scanner.nextInt();
                    scanner.nextLine();
                    
                    warehouse.creaseProduct(name, amount, new Product.Increase(), warehouse.new creaseProductByName());
                    break;
                    
                case 3:
                    System.out.print("請輸入商品名稱:");
                    name = scanner.nextLine();
                    System.out.print("請輸入商品數量:");
                    amount = scanner.nextInt();
                    scanner.nextLine();
                    
                    warehouse.creaseProduct(name, amount, new Product.Decrease(), warehouse.new creaseProductByName());         
                    break;
                    
                case 4:
                    System.out.print("請輸入商品類別名稱:");
                    category = scanner.nextLine();
                    System.out.print("請輸入商品數量:");
                    amount = scanner.nextInt();
                    scanner.nextLine();
                    
                    warehouse.creaseProduct(category, amount, new Product.Increase(), warehouse.new creaseProductByCategory());         
                    break;
                    
                case 5:
                    System.out.print("請輸入商品類別名稱:");
                    category = scanner.nextLine();
                    System.out.print("請輸入商品數量:");
                    amount = scanner.nextInt();
                    scanner.nextLine();
                    
                    warehouse.creaseProduct(category, amount, new Product.Decrease(), warehouse.new creaseProductByCategory());         
                    break;
                                        
                case 6:
                    System.out.print("請輸入標籤名稱:");
                    tag = scanner.nextLine();                    
                    
                    warehouse.printByTag(tag);
                    break;
                    
                case 7:
                    warehouse.printAll();
            }
            
        } while (true);
        
        
        
    }
    
}
