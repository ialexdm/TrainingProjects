import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Data {
    public static List<Data> dataList = new ArrayList<>();
    private String packageID;
    private String article;
    private String supplier;
    private String division;
    private String status;
    private String docNumberVersionWhatsWrong;
    public Data(String article, String supplier,String packageID, String division, String status, String docNumber, String docVersion, String whatsWrong) throws IOException {

        this.article = article;
        this.supplier = supplier;
        this.division = division;
        this.packageID = packageID;
        this.status = status;
        this.docNumberVersionWhatsWrong = docNumber + "-" + docVersion + " = " + whatsWrong;
        dataList.add(this);

    }


    public static List<Data> getDataList() {
        return dataList;
    }

    public String getPackageID() {
        return packageID;
    }

    public String getArticle() {
        return article;
    }

    public String getSupplier() {
        return supplier;
    }

    public String getDivision() {
        return division;
    }

    public String getStatus() {
        return status;
    }

    public String getDocNumberVersionWhatsWrong() {
        return docNumberVersionWhatsWrong;
    }
}
