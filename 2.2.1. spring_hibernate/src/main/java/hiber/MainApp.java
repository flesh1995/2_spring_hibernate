package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      userService.add(new User(new Car("BMW", 5),
              "User1", "Lastname1", "user1@mail.ru"));
      userService.add(new User(new Car("Mers", 3),
              "User2", "Lastname2", "user2@mail.ru"));
      userService.add(new User(new Car("Audi", 2),
              "User3", "Lastname3", "user3@mail.ru"));
      userService.add(new User(new Car("Lada", 10),
              "User4", "Lastname4", "user4@mail.ru"));

      for (User user : userService.listUsers()) {
         System.out.println(user + " " + user.getCar());
      }

      System.out.println(userService.getUserCar("Audi", 2));
//      List<User> users = userService.listUsers();
//      for (User user : users) {
//         System.out.println("Id = "+user.getId());
//         System.out.println("First Name = "+user.getFirstName());
//         System.out.println("Last Name = "+user.getLastName());
//         System.out.println("Email = "+user.getEmail());
//         System.out.println();
//      }
      context.close();
   }
}
