package hospital.linkedlist;

public class VisitHistory {

    Visit first;

    public VisitHistory() {

        first = null;
    }

    public boolean isEmpty() {

        return first == null;
    }

    public void addVisit(Visit newVisit) {

        if (isEmpty()) {

            first = newVisit;

        } else {

            Visit current = first;

            while (current.next != null) {

                current = current.next;
            }

            current.next = newVisit;
        }

        System.out.println("Visit added successfully.");
    }

    public void displayHistory() {

        if (isEmpty()) {

            System.out.println("Visit history is empty.");
            return;
        }

        Visit current = first;

        while (current != null) {

            current.displayVisit();

            current = current.next;
        }
    }

    public Visit searchVisit(String visitId) {

        Visit current = first;

        while (current != null) {

            if (current.visitId.equals(visitId)) {

                return current;
            }

            current = current.next;
        }

        return null;
    }

    public boolean removeVisit(String visitId) {

        if (isEmpty()) {

            System.out.println("Visit history is empty.");
            return false;
        }

        if (first.visitId.equals(visitId)) {

            first = first.next;

            System.out.println("Visit removed successfully.");
            return true;
        }

        Visit current = first;

        while (current.next != null) {

            if (current.next.visitId.equals(visitId)) {

                current.next = current.next.next;

                System.out.println("Visit removed successfully.");
                return true;
            }

            current = current.next;
        }

        System.out.println("Visit not found.");
        return false;
    }
}