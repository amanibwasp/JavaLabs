package org.example;

import org.example.entity.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CinemaManager {
    private static List<Cinema> cinemas = new ArrayList<>();
    private static List<Movie> movies = new ArrayList<>();
    private static List<Session> sessions = new ArrayList<>();
    private static List<User> users = new ArrayList<>();
    private static List<Ticket> tickets = new ArrayList<>();
    private static User currentUser = null;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        initData();
        
        while (true) {
            if (currentUser == null) {
                showLoginMenu();
            } else if (currentUser.isAdmin) {
                showAdminMenu();
            } else {
                showUserMenu();
            }
        }
    }

    private static void initData() {
        users.add(new User("admin", "admin123", true));
        users.add(new User("user", "user123", false));

        Cinema cinema1 = new Cinema("Киномакс", "ул. Кирова, 15");
        cinema1.halls.add(new Hall(1, 10, 15));
        cinema1.halls.add(new Hall(2, 8, 12));
        cinemas.add(cinema1);
        
        Cinema cinema2 = new Cinema("Синема Парк", "пр. Ленина, 42");
        cinema2.halls.add(new Hall(1, 12, 20));
        cinemas.add(cinema2);

        movies.add(new Movie("Интерстеллар", 169));
        movies.add(new Movie("Крестный отец", 175));
        movies.add(new Movie("Форсаж 9", 143));

        LocalDateTime now = LocalDateTime.now();
        sessions.add(new Session(movies.get(0), cinema1.halls.get(0), 
                    now.plusHours(2), cinema1));
        sessions.add(new Session(movies.get(1), cinema1.halls.get(1), 
                    now.plusHours(3), cinema1));
        sessions.add(new Session(movies.get(2), cinema2.halls.get(0), 
                    now.plusHours(1), cinema2));
    }

    private static void showLoginMenu() {
        System.out.println("\nБилетная система кинотеатров");
        System.out.println("1. Вход");
        System.out.println("2. Регистрация");
        System.out.println("0. Выход");
        System.out.print("Выберите действие: ");
        
        int choice = scanner.nextInt();
        scanner.nextLine();
        
        switch (choice) {
            case 1:
                login();
                break;
            case 2:
                register();
                break;
            case 0:
                System.exit(0);
            default:
                System.out.println("Неверный выбор!");
        }
    }

    private static void login() {
        System.out.print("Логин: ");
        String username = scanner.nextLine();
        System.out.print("Пароль: ");
        String password = scanner.nextLine();
        
        for (User user : users) {
            if (user.username.equals(username) && user.password.equals(password)) {
                currentUser = user;
                System.out.println("Добро пожаловать, " + username + "!");
                return;
            }
        }
        
        System.out.println("Неверный логин или пароль!");
    }

    private static void register() {
        System.out.print("Придумайте логин: ");
        String username = scanner.nextLine();

        for (User user : users) {
            if (user.username.equals(username)) {
                System.out.println("Этот логин уже занят!");
                return;
            }
        }
        
        System.out.print("Придумайте пароль: ");
        String password = scanner.nextLine();
        
        users.add(new User(username, password, false));
        System.out.println("Регистрация прошла успешно!");
    }

    private static void showAdminMenu() {
        System.out.println("\nАдминистраторская панель");
        System.out.println("1. Добавить кинотеатр");
        System.out.println("2. Добавить зал");
        System.out.println("3. Добавить фильм");
        System.out.println("4. Создать сеанс");
        System.out.println("5. Просмотреть все сеансы");
        System.out.println("6. Просмотреть план зала");
        System.out.println("0. Выход");
        System.out.print("Выберите действие: ");
        
        int choice = scanner.nextInt();
        scanner.nextLine();
        
        switch (choice) {
            case 1:
                addCinema();
                break;
            case 2:
                addHall();
                break;
            case 3:
                addMovie();
                break;
            case 4:
                createSession();
                break;
            case 5:
                viewAllSessions();
                break;
            case 6:
                viewHallLayout();
                break;
            case 0:
                currentUser = null;
                break;
            default:
                System.out.println("Неверный выбор!");
        }
    }

    private static void showUserMenu() {
        System.out.println("\nПользовательское меню");
        System.out.println("1. Поиск сеансов");
        System.out.println("2. Купить билет");
        System.out.println("3. Мои билеты");
        System.out.println("0. Выход");
        System.out.print("Выберите действие: ");
        
        int choice = scanner.nextInt();
        scanner.nextLine();
        
        switch (choice) {
            case 1:
                searchSessions();
                break;
            case 2:
                buyTicket();
                break;
            case 3:
                viewMyTickets();
                break;
            case 0:
                currentUser = null;
                break;
            default:
                System.out.println("Неверный выбор!");
        }
    }

    private static void addCinema() {
        System.out.print("Название кинотеатра: ");
        String name = scanner.nextLine();
        System.out.print("Адрес: ");
        String address = scanner.nextLine();
        
        cinemas.add(new Cinema(name, address));
        System.out.println("Кинотеатр успешно добавлен!");
    }

    private static void addHall() {
        System.out.println("Выберите кинотеатр:");
        for (int i = 0; i < cinemas.size(); i++) {
            System.out.println((i+1) + ". " + cinemas.get(i).name);
        }
        System.out.print("Ваш выбор: ");
        int cinemaIndex = scanner.nextInt() - 1;
        
        System.out.print("Номер зала: ");
        int number = scanner.nextInt();
        System.out.print("Количество рядов: ");
        int rows = scanner.nextInt();
        System.out.print("Мест в ряду: ");
        int seatsPerRow = scanner.nextInt();
        
        cinemas.get(cinemaIndex).halls.add(new Hall(number, rows, seatsPerRow));
        System.out.println("Зал успешно добавлен!");
    }

    private static void addMovie() {
        System.out.print("Название фильма: ");
        String title = scanner.nextLine();
        System.out.print("Длительность (мин): ");
        int duration = scanner.nextInt();
        scanner.nextLine();
        
        movies.add(new Movie(title, duration));
        System.out.println("Фильм успешно добавлен!");
    }

    private static void createSession() {
        System.out.println("Выберите кинотеатр:");
        for (int i = 0; i < cinemas.size(); i++) {
            System.out.println((i+1) + ". " + cinemas.get(i).name);
        }
        System.out.print("Ваш выбор: ");
        int cinemaIndex = scanner.nextInt() - 1;
        Cinema cinema = cinemas.get(cinemaIndex);
        
        System.out.println("Выберите зал:");
        for (int i = 0; i < cinema.halls.size(); i++) {
            System.out.println((i+1) + ". Зал " + cinema.halls.get(i).number);
        }
        System.out.print("Ваш выбор: ");
        int hallIndex = scanner.nextInt() - 1;
        Hall hall = cinema.halls.get(hallIndex);
        
        System.out.println("Выберите фильм:");
        for (int i = 0; i < movies.size(); i++) {
            System.out.println((i+1) + ". " + movies.get(i).title);
        }
        System.out.print("Ваш выбор: ");
        int movieIndex = scanner.nextInt() - 1;
        Movie movie = movies.get(movieIndex);
        
        System.out.print("Год начала сеанса (yyyy): ");
        int year = scanner.nextInt();
        System.out.print("Месяц (1-12): ");
        int month = scanner.nextInt();
        System.out.print("День (1-31): ");
        int day = scanner.nextInt();
        System.out.print("Час (0-23): ");
        int hour = scanner.nextInt();
        System.out.print("Минута (0-59): ");
        int minute = scanner.nextInt();
        
        LocalDateTime startTime = LocalDateTime.of(year, month, day, hour, minute);
        sessions.add(new Session(movie, hall, startTime, cinema));
        System.out.println("Сеанс успешно создан!");
    }

    private static void viewAllSessions() {
        System.out.println("\nВсе сеансы");
        for (Session session : sessions) {
            System.out.printf("Кинотеатр: %s, Зал: %d, Фильм: %s, Начало: %s%n",
                session.cinema.name, session.hall.number, 
                session.movie.title, session.startTime.toString());
        }
    }

    private static void viewHallLayout() {
        System.out.println("Выберите сеанс:");
        for (int i = 0; i < sessions.size(); i++) {
            Session s = sessions.get(i);
            System.out.printf("%d. %s - %s (зал %d)%n",
                i+1, s.movie.title, s.startTime.toString(), s.hall.number);
        }
        System.out.print("Ваш выбор: ");
        int sessionIndex = scanner.nextInt() - 1;
        Session session = sessions.get(sessionIndex);
        
        System.out.println("\nПлан зала:");
        System.out.println("Экран");
        System.out.println("---------------------");
        
        for (int row = 0; row < session.hall.rows; row++) {
            for (int seat = 0; seat < session.hall.seatsPerRow; seat++) {
                boolean isOccupied = false;
                for (Ticket ticket : tickets) {
                    if (ticket.session == session && ticket.row == row && ticket.seat == seat) {
                        isOccupied = true;
                        break;
                    }
                }
                System.out.print(isOccupied ? "[X] " : "[ ] ");
            }
            System.out.println(" Ряд " + (row + 1));
        }
    }

    private static void searchSessions() {
        System.out.print("Введите название фильма (или оставьте пустым для всех): ");
        String searchTitle = scanner.nextLine();
        
        System.out.println("\nНайденные сеансы");
        for (Session session : sessions) {
            if (searchTitle.isEmpty() || session.movie.title.toLowerCase().contains(searchTitle.toLowerCase())) {
                int freeSeats = countFreeSeats(session);
                if (freeSeats > 0) {
                    System.out.printf("Кинотеатр: %s, Зал: %d, Фильм: %s, Начало: %s, Свободных мест: %d%n",
                        session.cinema.name, session.hall.number, 
                        session.movie.title, session.startTime.toString(), freeSeats);
                }
            }
        }
    }

    private static int countFreeSeats(Session session) {
        int totalSeats = session.hall.rows * session.hall.seatsPerRow;
        int occupied = 0;
        
        for (Ticket ticket : tickets) {
            if (ticket.session == session) {
                occupied++;
            }
        }
        
        return totalSeats - occupied;
    }

    private static void buyTicket() {
        System.out.println("Выберите сеанс:");
        List<Session> availableSessions = new ArrayList<>();
        int index = 1;
        
        for (Session session : sessions) {
            if (countFreeSeats(session) > 0) {
                System.out.printf("%d. %s - %s (зал %d, свободно %d мест)%n",
                    index++, session.movie.title, session.startTime.toString(),
                    session.hall.number, countFreeSeats(session));
                availableSessions.add(session);
            }
        }
        
        if (availableSessions.isEmpty()) {
            System.out.println("Нет доступных сеансов!");
            return;
        }
        
        System.out.print("Ваш выбор: ");
        int sessionIndex = scanner.nextInt() - 1;
        Session session = availableSessions.get(sessionIndex);

        System.out.println("\nПлан зала:");
        System.out.println("Экран");
        System.out.println("---------------------");
        
        for (int row = 0; row < session.hall.rows; row++) {
            for (int seat = 0; seat < session.hall.seatsPerRow; seat++) {
                boolean isOccupied = false;
                for (Ticket ticket : tickets) {
                    if (ticket.session == session && ticket.row == row && ticket.seat == seat) {
                        isOccupied = true;
                        break;
                    }
                }
                System.out.print(isOccupied ? "[X] " : "[ ] ");
            }
            System.out.println(" Ряд " + (row + 1));
        }

        System.out.print("Выберите ряд: ");
        int row = scanner.nextInt() - 1;
        System.out.print("Выберите место: ");
        int seat = scanner.nextInt() - 1;

        for (Ticket ticket : tickets) {
            if (ticket.session == session && ticket.row == row && ticket.seat == seat) {
                System.out.println("Это место уже занято!");
                return;
            }
        }

        tickets.add(new Ticket(session, row, seat, currentUser));
        System.out.println("Билет успешно куплен!");
    }

    private static void viewMyTickets() {
        System.out.println("\nВаши билеты");
        boolean hasTickets = false;
        
        for (Ticket ticket : tickets) {
            if (ticket.user == currentUser) {
                hasTickets = true;
                System.out.printf("Фильм: %s, Кинотеатр: %s, Зал: %d, Ряд: %d, Место: %d, Время: %s%n",
                    ticket.session.movie.title, ticket.session.cinema.name,
                    ticket.session.hall.number, ticket.row + 1, ticket.seat + 1,
                    ticket.session.startTime.toString());
            }
        }
        
        if (!hasTickets) {
            System.out.println("У вас нет купленных билетов.");
        }
    }
}