// Source code is decompiled from a .class file using FernFlower decompiler.
class Admin {
   String name;
   Theater theater;

   public Admin(String var1, Theater var2) {
      this.name = var1;
      this.theater = var2;
   }

   public void addMovie(Movie var1) {
      this.theater.addMovie(var1);
      System.out.println(var1.title + " added to " + this.theater.name);
   }

   public void viewSeatAvailability() {
      System.out.println("Available Seats in " + this.theater.name + ":");
      System.out.println("Royal: " + this.theater.royalSeats);
      System.out.println("Premium: " + this.theater.premiumSeats);
      System.out.println("Executive: " + this.theater.executiveSeats);
   }
}
