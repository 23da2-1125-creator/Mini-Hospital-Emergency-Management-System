package hospital.queue;

import hospital.bst.Patient;

public class EmergencyQueue {

    Patient[] queue;
    int front;
    int rear;
    int count;

    public EmergencyQueue(int size) {

        queue = new Patient[size];

        front = 0;
        rear = -1;
        count = 0;
    }

    public void enqueue(Patient patient) {

        if (count == queue.length) {

            System.out.println("Queue is full.");
            return;
        }

        rear++;

        queue[rear] = patient;

        count++;

        System.out.println("Patient added to emergency queue.");
    }

    public Patient dequeue() {

        if (count == 0) {

            System.out.println("Queue is empty.");
            return null;
        }

        Patient temp = queue[front];

        front++;

        count--;

        return temp;
    }

    public void displayQueue() {

        if (count == 0) {

            System.out.println("Queue is empty.");
            return;
        }

        System.out.println("Emergency Waiting Queue");
        System.out.println("-----------------------");

        int index = front;

        for (int i = 0; i < count; i++) {

            queue[index].displayPatient();

            index++;
        }
    }
}