import dao.BusDAO;
import dao.PassengerDAO;
import model.Bus;
import model.Passenger;
import util.InputUtil;

import java.time.LocalDateTime;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        BusDAO busDAO = new BusDAO();
        PassengerDAO passengerDAO = new PassengerDAO();

        while (true) {
            System.out.println("\n===== BUS BOOKING MENU =====");
            System.out.println("1. Add Bus");
            System.out.println("2. View All Buses");
            System.out.println("3. Book Passenger");
            System.out.println("4. View All Passengers");
            System.out.println("5. View Passengers by Bus ID");
            System.out.println("6. Exit");

            int choice = InputUtil.num("Enter choice: ");

            try {
                switch (choice) {
                    case 1 -> {
                        String busNo = InputUtil.str("Bus No: ");
                        String date = InputUtil.str("Departure (yyyy-MM-ddTHH:mm): ");
                        LocalDateTime dt = LocalDateTime.parse(date);

                        int seats = InputUtil.num("Seats: ");
                        String sp = InputUtil.str("Start: ");
                        String ep = InputUtil.str("End: ");

                        Bus bus = new Bus(busNo, dt, seats, sp, ep);
                        busDAO.addBus(bus);
                        System.out.println("Bus added!");
                    }

                    case 2 -> {
                        List<Bus> buses = busDAO.getAllBuses();
                        buses.forEach(System.out::println);
                    }

                    case 3 -> {
                        String name = InputUtil.str("Passenger Name: ");
                        int age = InputUtil.num("Age: ");
                        double amt = InputUtil.dbl("Amount: ");
                        int busId = InputUtil.num("Bus ID: ");
                        String src = InputUtil.str("Source: ");
                        String dest = InputUtil.str("Destination: ");

                        Passenger p = new Passenger(name, age, amt, busId, src, dest);

                        if (passengerDAO.bookPassenger(p)) {
                            System.out.println("Booking successful!");
                        } else {
                            System.out.println("Booking failed!");
                        }
                    }

                    case 4 -> {
                        List<Passenger> list = passengerDAO.getAllPassengers();
                        list.forEach(System.out::println);
                    }

                    case 5 -> {
                        int busId = InputUtil.num("Enter Bus ID: ");
                        List<Passenger> list = passengerDAO.getPassengersByBus(busId);
                        list.forEach(System.out::println);
                    }

                    case 6 -> {
                        System.out.println("Thank you!");
                        System.exit(0);
                    }

                    default -> System.out.println("Invalid choice!");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
