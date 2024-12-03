/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productmanagesystem;

/**
 *
 * @author Eka
 */
public class Product {
    private String name;
    private int price;
    private String category;
    private int amount;
    private String tag;
    private String secCategory;
    
    public Product(){
        
    }    
    
    public static class Builder{
        public Product product;
        public Builder(String name, int price, String category, int amount){
            product = new Product(name, price, category, amount);
        }
        public Builder setTag(String tag){
            if (!tag.equals("N")){
                product.tag = tag;
            }
            return this;
        }
        public Builder setSecCategory(String secCategory){
            if (!secCategory.equals("N")){
                product.secCategory = secCategory;
            }
            
            return this;
        }
        public Product gen(){
            Product tmp = product;
            product = null;
            return tmp;
        }
    }
    
    private Product(String name, int price, String category, int amount){
        this.name = name;
        this.price = price;
        this.category = category;
        this.amount= amount;
    }
    
    public String getName(){
        return name;
    }
    public String getCategory(){
        return category;
    }   
    public String getSecCategory(){
        return secCategory;
    }
    public String getTag(){
        return tag;
    }
    
    public static interface Adjustment{
        public boolean checkCrease(Product product,int variation);
    }
    
    public static class Decrease implements Adjustment{
        @Override
        public boolean checkCrease(Product product, int variation){
            if (variation > product.amount){
                System.out.println("商品數量不足");
                return false;
            }
            product.amount -= variation;
            return true;
        }
    }
    
    public static class Increase implements Adjustment{
        @Override
        public boolean checkCrease(Product product, int variation){
            product.amount += variation;
            return true;
        }
    }
    
    public boolean adjProduct(Adjustment adjustment, int variation){
        return adjustment.checkCrease(this, variation);
    }
    
    @Override
    public String toString(){
        return " 名稱: " + name + " 價格: " + price + " 分類: " + category + " 庫存量: " + amount + " 標籤: " + (tag == null ? " ": tag) + " 第二分類: " + (secCategory == null ? " ": secCategory);
    }
    
}
