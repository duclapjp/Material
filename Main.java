import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Material material1 = new CrispyFlour("c1","lập", LocalDate.of(1994,10,10),1000,10);
        Material material2 = new CrispyFlour("c2","thái", LocalDate.of(1998,9,8),2000,5);
        Material material3 = new CrispyFlour("c3","Xa", LocalDate.of(1994,10,10),3000,4);
        Material material4 = new Meat("c4","an", LocalDate.of(1999,5,10),3000,40);
        Material material5 = new Meat("c5","lêu lêu", LocalDate.of(1999,9,10),2000,80);
        List<Material> materialLis = new ArrayList<>();
        materialLis.add(material1);
        materialLis.add(material2);
        materialLis.add(material3);
        materialLis.add(material4);
        materialLis.add(material5);
       ManagerMaterial lap = new ManagerMaterial();
        System.out.println("MENU");
        System.out.println("1.Hiển thị sản phẩm");
        System.out.println("2.Thêm sản phẩm");
        System.out.println("3.Sửa sản phẩm");
        System.out.println("4.Xóa sản phẩm");
        Scanner scanner = new Scanner(System.in);
        switchMenu(materialLis, lap, scanner);
    }



    private static void switchMenu(List<Material> materialLis, ManagerMaterial lap, Scanner scanner) {
        int choice = scanner.nextInt();
        switch (choice){
            case 1:
                show(materialLis, lap);
                break;
            case 2:
                add(lap, scanner);
                break;
            case 3:
                editput(materialLis, lap, scanner);
                break;
            case 4:
                delete(materialLis, lap, scanner);
        }
    }

    private static void add(ManagerMaterial lap, Scanner scanner) {
        System.out.println("Menu");
        System.out.println("1:CrispyFour");
        System.out.println("2:Meat");
        int choice2 = scanner.nextInt();
        editByAdd(lap, scanner, choice2);
        return;
    }

    private static void show(List<Material> materialLis, ManagerMaterial lap) {
        lap.setMaterialList(materialLis);
        lap.displayMaterial();
    }

    private static void delete(List<Material> materialLis, ManagerMaterial lap, Scanner scanner) {
        System.out.println("nhập vào vị trí muốn xóa");
        int indexByRemove = scanner.nextInt();
        lap.removeMaterial(materialLis,indexByRemove);
        lap.setMaterialList(materialLis);
        lap.displayMaterial();
    }

    private static void editput(List<Material> materialLis, ManagerMaterial lap, Scanner scanner) {
        System.out.println("nhập vào vị trí muốn sửa");
        int indexByAdd = scanner.nextInt();
        lap.editMaterial(materialLis,indexByAdd);
        lap.setMaterialList(materialLis);
        lap.displayMaterial();
    }

    private static void editByAdd(ManagerMaterial lap, Scanner scanner, int choice2) {
        switch (choice2){
            case 1:
                System.out.println("nhập id");
               String addId  = scanner.nextLine();
                System.out.println("nhập tên");
               String  addName  = scanner.nextLine();
                System.out.println("nhập thời gian: năm, tháng, ngày");
                int year = scanner.nextInt();
                int month = scanner.nextInt();
                int day = scanner.nextInt();
                System.out.println("nhập giá");
               int addCost = scanner.nextInt();
                System.out.println("nhập số lượng");
               int addQuantity = scanner.nextInt();
                Material addMaterial = new CrispyFlour(addId,addName,LocalDate.of(year,month,day),addCost,addQuantity);
                lap.addMaterial(addMaterial);
                lap.displayMaterial();
                break;
            case 2:
                System.out.println("nhập id");
                String addId2  = scanner.nextLine();
                System.out.println("nhập tên");
                String  addName2  = scanner.nextLine();
                int year2 = scanner.nextInt();
                int month2 = scanner.nextInt();
                int day2 = scanner.nextInt();
                System.out.println("nhập giá");
                int addCost2 = scanner.nextInt();
                System.out.println("nhập số lượng ");
                int addQuantity2 = scanner.nextInt();
                Material addMaterial2 = new Meat(addId2,addName2,LocalDate.of(year2,month2,day2),addCost2,addQuantity2);
                lap.addMaterial(addMaterial2);
                lap.displayMaterial();
                break;
        }
    }

}
