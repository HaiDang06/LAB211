package main;

import constant.Constants;
import constant.Message;
import controller.Controller;
import dto.TaskDTO;
import constant.TaskType;
import java.util.Scanner;
import utils.Validation;

public class Main {

    // Phuong thuc chinh dieu huong luong hoat động cua toan bo chuong trinh
    public static void main(String[] args) {
        Controller control = new Controller();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println(Message.MENU_HEADER.concat(Message.MENU_BODY));
            try {
                System.out.print(Message.INPUT_CHOICE);
                int choice = Validation.getInt(sc.nextLine(), 1, 4);

                switch (choice) {
                    case 1:
                        TaskDTO addDto = new TaskDTO();
                        control.setDto(addDto);

                        System.out.print(Message.INPUT_REQUIREMENT_NAME);
                        addDto.setRequirementName(Validation.getString(sc.nextLine(), Constants.REGEX_NAME));

                        System.out.print(Message.INPUT_TASK_TYPE_CHOICE);
                        addDto.setTaskType(TaskType.getTaskTypeById(Validation.getInt(sc.nextLine(), 1, 4)));

                        System.out.print(Message.INPUT_DATE);
                        addDto.setDate(Validation.getDate(sc.nextLine(), Constants.DATE_FORMAT_PATTERN));

                        System.out.print(Message.INPUT_PLAN_FROM);
                        double planFrom = Validation.getDouble(sc.nextLine(), 8.0, 17.0);
                        addDto.setPlanFrom(planFrom);

                        System.out.print(Message.INPUT_PLAN_TO);
                        // planTo phải lớn hơn planFrom ít nhất 0.5
                        double planTo = Validation.getDouble(sc.nextLine(), planFrom + 0.5, 17.5);
                        addDto.setPlanTo(planTo);

                        System.out.print(Message.INPUT_ASSIGNEE);
                        addDto.setAssign(Validation.getString(sc.nextLine(), Constants.REGEX_NAME));

                        System.out.print(Message.INPUT_REVIEWER);
                        addDto.setReviewer(Validation.getString(sc.nextLine(), Constants.REGEX_NAME));

                        control.addTask();
                        break;

                    case 2:
                        TaskDTO deleteDto = new TaskDTO();
                        control.setDto(deleteDto);

                        System.out.print(Message.INPUT_TASK_ID);
                        deleteDto.setId(Validation.getInt(sc.nextLine(), 1, Integer.MAX_VALUE));

                        control.deleteTask();
                        break;
                    case 3:
                        control.showTasks();
                        break;
                    case 4:
                        System.exit(0);
                        return;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
