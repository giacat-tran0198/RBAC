import model.*;
import service.AccessService;
import service.AccessServiceInterface;

public class Main {
    public static void main(String[] args) {
        // User
        User gosling = new User("James", "Gosling");

        // 2 actions
        Action read = new Action("read");
        Action write = new Action("write");

        // 1 resource
        Resource myFile = new Resource("myFile.txt");

        // Auth
        Authorization readPersoFile = new Authorization("ReadPersoFile", read, myFile);

        // Role
        Role baserole = new Role("baserole");
        baserole.addAuth(readPersoFile);
        baserole.addUser(gosling);

        // Monitor
        Monitor monitor = new Monitor("monitor1");
        monitor.addRole(baserole);

        // Service
        AccessServiceInterface service = new AccessService();
        String result;

        // time 1 for read
        result = service.accessResource(gosling, monitor, read, myFile);
        System.out.printf("time 1st: user %s  %s the file '%s' in the monitor '%s'%n", gosling.getLastName(), read.getName(), myFile.getName(), monitor.getName());
        System.out.println("result: " + result);
        System.out.println("==================");

        // time 1 for write
        result = service.accessResource(gosling, monitor, write, myFile);
        System.out.printf("time 2nd: user %s  %s the file '%s' in the monitor '%s'%n", gosling.getLastName(), write.getName(), myFile.getName(), monitor.getName());
        System.out.println("result: " + result);
        System.out.println("==================");

        // time 2 for write
        result = service.accessResource(gosling, monitor, write, myFile);
        System.out.printf("time 3th: user %s  %s the file '%s' in the monitor '%s'%n", gosling.getLastName(), write.getName(), myFile.getName(), monitor.getName());
        System.out.println("result: " + result);
        System.out.println("==================");

        // time 3 for write
        result = service.accessResource(gosling, monitor, write, myFile);
        System.out.printf("time 4th: user %s  %s the file '%s' in the monitor '%s'%n", gosling.getLastName(), write.getName(), myFile.getName(), monitor.getName());
        System.out.println("result: " + result);
        System.out.println("==================");

        // time 2 for read
        result = service.accessResource(gosling, monitor, read, myFile);
        System.out.printf("time 5th: user %s  %s the file '%s' in the monitor '%s'%n", gosling.getLastName(), read.getName(), myFile.getName(), monitor.getName());
        System.out.println("result: " + result);
    }
}
