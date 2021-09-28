import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class ManagerMaterial {
   private List<Material> materialList;

    public ManagerMaterial(List<Material> materialList) {
        this.materialList = materialList;
    }

    public ManagerMaterial() {
    }

    public List<Material> getMaterialList() {
        return materialList;
    }

    public void setMaterialList(List<Material> materialList) {
        this.materialList = materialList;
    }
    public void displayMaterial(){
        System.out.println("danh sách sản phẩm là:");
        for (Material material: materialList) {
            System.out.println(material);
        }
    }
    public void addMaterial(Material material){
        materialList.add(material);
    }
    public void removeMaterial(List<Material> materialList, int index){
        materialList.remove(index);
    }
    public void editMaterial(List<Material> materialList, int index){
        System.out.println("MENU");
        System.out.println("nhập số cần sửa");
        System.out.println("1:ID");
        System.out.println("2:Tên");
        System.out.println("3:Date");
        System.out.println("4:Gía");
        System.out.println("5:Số lượng");
        System.out.println("6:trọng lượng");
        System.out.println("7:Exit");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        extracted(materialList, index, scanner, choice);
    }

    private void extracted(List<Material> materialList, int index, Scanner scanner, int choice) {
        switch (choice){
            case 1:
                System.out.println("nhập id mới");
                String p = scanner.nextLine();
                String newId = scanner.nextLine();
            materialList.get(index).setId(newId);
                break;
            case 2:
                System.out.println("nhập tên mới");
                String newName = scanner.nextLine();
            materialList.get(index).setName(newName);
                break;
            case 3:
                System.out.println("nhập năm");
                int year = scanner.nextInt();
                System.out.println("nhập tháng");
                int month = scanner.nextInt();
                System.out.println("nhập ngày");
                int day = scanner.nextInt();
                materialList.get(index).setManufacturingDate(LocalDate.of(year,month,day));
            case 4:
                System.out.println("nhập giá mới");
                int newCost = scanner.nextInt();
            materialList.get(index).setCost(newCost);
                break;
            case 5:
                System.out.println("nhập lại số lượng");
                int newQuantity = scanner.nextInt();
                if (materialList.get(index) instanceof CrispyFlour) {
                    ((CrispyFlour) materialList.get(index)).setQuantity(newQuantity);
                }else {
                    System.out.println("không có trong danh sách");
                }
                break;
            case 6:
                System.out.println("nhập lại trọng lượng");
                double newWeight = scanner.nextDouble();
                if (materialList.get(index) instanceof Meat){
                    ((Meat)materialList.get(index)).setWeight(newWeight);
                }
                break;
            case 7:
                System.out.println("Exit");
            default:
                System.out.println("vui lòng nhập lại");
        }
    }
}
