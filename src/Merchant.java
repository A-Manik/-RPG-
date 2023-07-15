public class Merchant implements Seller{


    @Override
    public String sell(Goods goods) {
        String result = "";
        if (goods == Goods.POTION){
            return "potion";
        }
        return result;

    }

    public enum Goods {
        POTION
    }
}