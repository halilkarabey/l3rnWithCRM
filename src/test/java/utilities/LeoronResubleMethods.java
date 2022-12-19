package utilities;

public class LeoronResubleMethods {
    public void findCoursePayment(String pdfContent){
        String[] words = pdfContent.split(" ");

        String priceSentence = "";
        for (int i = 0; i < words.length; i++) {
            if (!words[i].equalsIgnoreCase("US$100")&words[i].contains("$")) {
                priceSentence = words[i];
                break;
            }
        }
        System.out.println("priceSentence = " + priceSentence);
        System.out.println("priceSentence.length() = " + priceSentence.length());
        String price=priceSentence.substring(12);
        System.out.println("price = " + price);
        //tamamlanacak
    }
}
