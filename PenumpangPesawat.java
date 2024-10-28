class Passenger {
    String name;
    Passenger next;


    public Passenger(String name) {
        this.name = name;
        this.next = null;
    }
}

class Flight {
    private Passenger head;


    public Flight() {
        this.head = null;
    }


    public void addPassenger(String name) {
        Passenger newPassenger = new Passenger(name);
        if (head == null) {
            head = newPassenger;
        } else {
            Passenger current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newPassenger;
        }
    }

    public void removePassenger(String name) {
        if (head == null) {
            System.out.println("Daftar penumpang kosong.");
            return;
        }

        if (head.name.equals(name)) {
            head = head.next;
            System.out.println(name + " telah dihapus dari daftar penumpang.");
            return;
        }

        Passenger current = head;
        while (current.next != null) {
            if (current.next.name.equals(name)) {
                current.next = current.next.next;
                System.out.println(name + " telah dihapus dari daftar penumpang.");
                return;
            }
            current = current.next;
        }

        System.out.println(name + " tidak ditemukan dalam daftar penumpang.");
    }

    public void displayPassengers() {
        Passenger current = head;
        if (current == null) {
            System.out.println("Daftar penumpang kosong.");
            return;
        }
        System.out.println("Daftar Penumpang:");
        while (current != null) {
            System.out.println("- " + current.name);
            current = current.next;
        }
    }
}


public class PenumpangPesawat {
    public static void main(String[] args) {
        Flight flight = new Flight();

        flight.addPassenger("Rani");
        flight.addPassenger("Dwi");
        flight.addPassenger("Sopia");
        flight.addPassenger("Aulia");
        flight.addPassenger("Haziqa");

        flight.displayPassengers();

        flight.removePassenger("Dwi");
        flight.displayPassengers();

        flight.removePassenger("Dinda"); // Penumpang tidak ada
    }
}
