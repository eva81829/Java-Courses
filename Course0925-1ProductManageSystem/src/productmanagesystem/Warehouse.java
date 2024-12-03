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
public class Warehouse {
    private Product[] products;
    private int count;
    
    public Warehouse(){
        count = 0;
        products = new Product[2];
    }
    
    public boolean setProduct(Product product){
        if (checkProductNameDup(product.getName())){
            System.out.println("商品重複");
            return false;
        }
        
        if (count==products.length){
            doubleArr();
        }
        products[count++] = product;
        return true;
    }
    
    public boolean checkProductNameDup(String name){
        for (int i=0; i<count; i++){
            if (products[i].getName().equals(name)){
                return true;
            }
        }
        return false;
    }
    
    public void doubleArr(){
        Product[] tmp = new Product[products.length*2];
        for(int i=0; i<count; i++){
            tmp[i] = products[i];
        }
        products = tmp;
    }
    
    public static interface CreaseProduct{
        public boolean creaseProduct(String str, int variation, Product.Adjustment adjustment);
    }
    
    public class creaseProductByName implements CreaseProduct{
        @Override
        public boolean creaseProduct(String str, int variation, Product.Adjustment adjustment){
            for (int i=0; i<count; i++){
                if(str.equals(products[i].getName())){
                    return products[i].adjProduct(adjustment, variation);
                }
            }
            System.out.println("無此商品");
            return false;
        }
    }

    public class creaseProductByCategory implements CreaseProduct{
        @Override
        public boolean creaseProduct(String str, int variation, Product.Adjustment adjustment){
            boolean checkCategory = false;
            for (int i=0; i<count; i++){
                if(str.equals(products[i].getCategory()) || str.equals(products[i].getSecCategory())){
                    products[i].adjProduct(adjustment, variation);
                    checkCategory = true;
                }
            }
            if (checkCategory == false){
                System.out.println("無此分類");
            }
            return checkCategory;
        }
    }

    public boolean creaseProduct(String str, int variation, Product.Adjustment adjustment, CreaseProduct creaseProduct){
        return creaseProduct.creaseProduct(str, variation, adjustment);
    }
    
    public void printByTag(String tag){
        for (int i=0; i<count; i++){
            if(products[i].getTag() != null && products[i].getTag().equals(tag)){
                System.out.println(products[i]);
            }
        }
    }
    
    public void printAll(){
        for (int i=0; i<count; i++){
            System.out.println(products[i]);
        }
    }    
    
}
