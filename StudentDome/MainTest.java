import java.util.Scanner;
import java.util.random.RandomGenerator;

public class MainTest {

    static Teacher teacher = new Teacher("李老师", 30);
    static Student[] studentList = {new Student("张三",18,80,80)
                                    ,new Student("李四",18,120,70)};


    public static void main(String[] args) {
        // 创建对象

        System.out.println("********************");
        System.out.println("欢迎使用学生成绩管理系统");
        System.out.println("********************");

        int role;
        Scanner input = new Scanner(System.in);
        boolean flag = true;

        do{
            System.out.println("请选择角色");
            System.out.println("1.教师");
            System.out.println("2.学生");
            System.out.println("3.退出");
            role = input.nextInt();

            switch (role){
                case 1:
//                    System.out.println("===进入教师管理系统===");
                    teacherMenu();
                    break;
                case 2:
//                    System.out.println("===进入学生成绩系统===");
                    studentMenu();
                    break;
                case 3:
                    flag = false;
                    System.out.println("===已成功退出===");
                    break;
            }
        }while(flag);

    }


    // 老师功能菜单
    public static void teacherMenu(){
        System.out.println("********************");
        System.out.println("欢迎使用教师成绩管理系统");
        System.out.println("********************");
        int option;
        Scanner input = new Scanner(System.in);
        boolean flag = true;
        do{
            System.out.println("请选择教师执行的操作");
            System.out.println("1.录入学生成绩");
            System.out.println("2.查询学生成绩");
            System.out.println("3.录入新学生信息");
            System.out.println("4.删除学生信息");
            System.out.println("5.任意键退出");

            option = input.nextInt();

            switch (option){
                case 1:
//                    System.out.println("===执行录入成绩操作===");
                    System.out.println("请输入学生姓名");
                    String name = input.next();
                    Student s = teacher.findStudentByName(studentList,name);
                    if(s!=null)
                        teacher.inputScore(s);
                    else
                        System.out.println("没有这个学生");
                    break;
                case 2:
//                    System.out.println("===查询所有学生信息===");
                    teacher.findAll(studentList);
                    break;
                case 3:
                    System.out.println("请输入新学生的姓名");
                    String newName = input.next();
                    System.out.println("请输入新学生的年龄");
                    int newAge = input.nextInt();
                    System.out.println("请输入新学生的数学成绩");
                    int newScore1 = input.nextInt();
                    System.out.println("请输入新学生的计算机成绩");
                    int newScore2 = input.nextInt();
                    Student newStudent = new Student(newName, newAge, newScore1, newScore2);

                    // 创建一个新的数组，比原数组大1
                    Student[] newStudentList = new Student[studentList.length + 1];

                    // 复制原数组的内容到新数组
                    for (int i = 0; i < studentList.length; i++) {
                        newStudentList[i] = studentList[i];
                    }

                    // 添加新的学生对象到新数组
                    newStudentList[studentList.length] = newStudent;

                    // 更新 studentList 以引用新数组
                    studentList = newStudentList;

                    System.out.println("新学生添加成功！");
                    break;
                case 4:
                    System.out.println("请输入要删除的学生姓名");
                    String delName = input.next();
                    int index = -1;

                    // 查找要删除的学生的索引
                    for (int i = 0; i < studentList.length; i++) {
                        if (studentList[i].name.equals(delName)) {
                            index = i;
                            break;
                        }
                    }

                    if (index != -1) {
                        // 创建一个新的数组，比原数组小1
                        Student[] tempStudentList = new Student[studentList.length - 1];

                        // 复制不包括被删除学生的其他学生
                        for (int i = 0, j = 0; i < studentList.length; i++) {
                            if (i != index) {
                                tempStudentList[j++] = studentList[i];
                            }
                        }

                        // 更新 studentList 以引用新数组
                        studentList = tempStudentList;

                        System.out.println("学生信息删除成功！");
                    } else {
                        System.out.println("没有找到这个学生");
                    }
                    break;
                default:
                    flag = false;
                    System.out.println("===已成功退出===");
            }
        }while(flag);
    }


    public static void chak(int option){
        Scanner input = new Scanner(System.in);
        System.out.println("输入学生姓名");
        String names = input.next();
        Student s = new Student();
        s = s.findStudentByName(studentList,names);
        if (option == 1){
            if(s!=null)
                s.chenji();
            else
                System.out.println("没有这个学生");
        }else if (option == 2){
            if(s!=null)
                s.showInfo();
            else
                System.out.println("没有这个学生");
        }

    }

    // 学生功能菜单
    public static void studentMenu(){
        System.out.println("********************");
        System.out.println("欢迎使用学生成绩管理系统");
        System.out.println("********************");
        int option;
        Scanner input = new Scanner(System.in);
        boolean flag = true;
        do{
            System.out.println("请选择学生执行的操作");
            System.out.println("1.查询成绩信息");
            System.out.println("2.查询个人信息");
            System.out.println("3.任意键退出");
            option = input.nextInt();

            switch (option){
                case 1, 2:  //  查看成绩或个人信息操作
                        chak(option);
                    break;
                default:
                    flag = false;
                    System.out.println("===已成功退出===");
            }
        }while(flag);
    }

}
