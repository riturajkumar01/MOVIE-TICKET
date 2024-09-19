import java.util.*;

// Movie Class
class Movie {
    String title;
    String genre;
    int duration; // in minutes
    
    public Movie(String title, String genre, int duration) {
        this.title = title;
        this.genre = genre;
        this.duration = duration;
    }

    @Override
    public String toString() {
        return title + " (" + genre + ", " + duration + " mins)";
    }
}

// Theater Class
class Theater {
    String name;
    
    // Seat availability for different categories
    int royalSeats = 20;
    int premiumSeats = 60;
    int executiveSeats = 20;
    
    List<Movie> movieList = new ArrayList<>();
    
    public Theater(String name) {
        this.name = name;
    }
    
    public void addMovie(Movie movie) {
        movieList.add(movie);
    }
    
    public void showMovies() {
        System.out.println("Movies in " + name + ":");
        for (int i = 0; i < movieList.size(); i++) {
            System.out.println((i + 1) + ". " + movieList.get(i));
        }
    }
    
    // Book seats based on type and availability
    public boolean bookSeats(String seatType, int seats) {
        switch (seatType) {
            case "Royal":
                if (royalSeats >= seats) {
                    royalSeats -= seats;
                    return true;
                }
                break;
            case "Premium":
                if (premiumSeats >= seats) {
                    premiumSeats -= seats;
                    return true;
                }
                break;
            case "Executive":
                if (executiveSeats >= seats) {
                    executiveSeats -= seats;
                    return true;
                }
                break;
        }
        return false;
    }
}

// Booking Class
class Booking {
    String userName;
    Theater theater;
    Movie movie;
    String seatType;
    int seats;
    UUID bookingID;
    List<String> allocatedSeats = new ArrayList<>();

    public Booking(String userName, Theater theater, Movie movie, String seatType, int seats) {
        this.userName = userName;
        this.theater = theater;
        this.movie = movie;
        this.seatType = seatType;
        this.seats = seats;
        this.bookingID = UUID.randomUUID();
    }
    
    // Generate seat numbers based on seat type
    public void generateSeatNumbers() {
        int seatCounter = 1;
        switch (seatType) {
            case "Royal":
                for (int i = 1; i <= seats; i++) {
                    allocatedSeats.add("R" + seatCounter);
                    seatCounter++;
                }
                break;
            case "Premium":
                for (int i = 1; i <= seats; i++) {
                    allocatedSeats.add("P" + seatCounter);
                    seatCounter++;
                }
                break;
            case "Executive":
                for (int i = 1; i <= seats; i++) {
                    allocatedSeats.add("E" + seatCounter);
                    seatCounter++;
                }
                break;
        }
    }

    public void confirmBooking() {
        if (theater.bookSeats(seatType, seats)) {
            generateSeatNumbers();
            System.out.println("Booking successful!");
            System.out.println("Booking ID: " + bookingID);
            System.out.println("Movie: " + movie.title);
            System.out.println("Theater: " + theater.name);
            System.out.println("Seat Type: " + seatType);
            System.out.println("Seats: " + allocatedSeats);
        } else {
            System.out.println("Booking failed. Not enough seats available.");
        }
    }
}

// Admin Class
class Admin {
    String name;
    Theater theater;
    
    public Admin(String name, Theater theater) {
        this.name = name;
        this.theater = theater;
    }
    
    public void addMovie(Movie movie) {
        theater.addMovie(movie);
        System.out.println(movie.title + " added to " + theater.name);
    }
    
    public void viewSeatAvailability() {
        System.out.println("Available Seats in " + theater.name + ":");
        System.out.println("Royal: " + theater.royalSeats);
        System.out.println("Premium: " + theater.premiumSeats);
        System.out.println("Executive: " + theater.executiveSeats);
    }
}

// Payment Class (simplified)
class Payment {
    public static void processPayment(double amount) {
        System.out.println("Processing payment of $" + amount + "...");
        System.out.println("Payment successful!");
    }
}

// Main Application
public class MovieTicketBookingSystem {
    
    public static void main(String[] args) {
        // Sample Data
        Theater theater = new Theater("Cineplex");
        Admin admin = new Admin("Admin1", theater);
        admin.addMovie(new Movie("Inception", "Sci-Fi", 148));
        admin.addMovie(new Movie("Titanic", "Romance", 195));
        
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Welcome to Movie Ticket Booking System");
            System.out.println("1. Browse Movies");
            System.out.println("2. Book Tickets");
            System.out.println("3. View Available Seats");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            
            switch (choice) {
                case 1:
                    theater.showMovies();
                    break;
                case 2:
                    sc.nextLine(); // clear the buffer
                    System.out.print("Enter your name: ");
                    String userName = sc.nextLine();
                    
                    theater.showMovies();
                    System.out.print("Select movie (1-" + theater.movieList.size() + "): ");
                    int movieChoice = sc.nextInt();
                    Movie selectedMovie = theater.movieList.get(movieChoice - 1);
// Royal seats are priced at $30 each.
// Premium seats are priced at $20 each.
// Executive seats are priced at $10 each.
                    System.out.println("Select seat type: 1. Royal  2. Premium  3. Executive");
                    int seatTypeChoice = sc.nextInt();
                    String seatType = "";
                    double pricePerSeat = 0.0;
                    
                    switch (seatTypeChoice) {
                        case 1:
                            seatType = "Royal";
                            pricePerSeat = 30.0; // Price for Royal seat
                            break;
                        case 2:
                            seatType = "Premium";
                            pricePerSeat = 20.0; // Price for Premium seat
                            break;
                        case 3:
                            seatType = "Executive";
                            pricePerSeat = 10.0; // Price for Executive seat
                            break;
                        default:
                            System.out.println("Invalid seat type.");
                            continue;
                    }
                    
                    System.out.print("Enter number of seats: ");
                    int seats = sc.nextInt();
                    
                    // Process Payment
                    double totalAmount = seats * pricePerSeat;
                    Payment.processPayment(totalAmount);
                    
                    // Confirm Booking
                    Booking booking = new Booking(userName, theater, selectedMovie, seatType, seats);
                    booking.confirmBooking();
                    break;
                case 3:
                    admin.viewSeatAvailability();
                    break;
                case 4:
                    System.out.println("Thank you for using the system.");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
