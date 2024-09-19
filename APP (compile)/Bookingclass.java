// Source code is decompiled from a .class file using FernFlower decompiler.
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

class Booking {
   String userName;
   Theater theater;
   Movie movie;
   String seatType;
   int seats;
   UUID bookingID;
   List<String> allocatedSeats = new ArrayList();

   public Booking(String var1, Theater var2, Movie var3, String var4, int var5) {
      this.userName = var1;
      this.theater = var2;
      this.movie = var3;
      this.seatType = var4;
      this.seats = var5;
      this.bookingID = UUID.randomUUID();
   }

   public void generateSeatNumbers() {
      int var1 = 1;
      int var4;
      switch (this.seatType) {
         case "Royal":
            for(var4 = 1; var4 <= this.seats; ++var4) {
               this.allocatedSeats.add("R" + var1);
               ++var1;
            }

            return;
         case "Premium":
            for(var4 = 1; var4 <= this.seats; ++var4) {
               this.allocatedSeats.add("P" + var1);
               ++var1;
            }

            return;
         case "Executive":
            for(var4 = 1; var4 <= this.seats; ++var4) {
               this.allocatedSeats.add("E" + var1);
               ++var1;
            }
      }

   }

   public void confirmBooking() {
      if (this.theater.bookSeats(this.seatType, this.seats)) {
         this.generateSeatNumbers();
         System.out.println("Booking successful!");
         System.out.println("Booking ID: " + String.valueOf(this.bookingID));
         System.out.println("Movie: " + this.movie.title);
         System.out.println("Theater: " + this.theater.name);
         System.out.println("Seat Type: " + this.seatType);
         System.out.println("Seats: " + String.valueOf(this.allocatedSeats));
      } else {
         System.out.println("Booking failed. Not enough seats available.");
      }

   }
}
