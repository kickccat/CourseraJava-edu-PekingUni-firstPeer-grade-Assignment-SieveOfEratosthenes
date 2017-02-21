/**
 * Finding the Prime number with the Sieb des Eratosthenes algorithm
 */

public class SieveOfEratosthenes {
    /**
     * Algorithm
     */

    static int[] eratosthenes(int max){
        final int maxLimit = (int)Math.sqrt(max) + 2;
        boolean[] numbers = new boolean[max]; // Set the boolean values False till max
        for (int i=0; i<max; i++) {
            numbers[i] = i%2 == 1; // Odd numbers will first observed
        }

        // Start from the prime number 3
        for (int prime=3; prime<maxLimit; prime+=2){
            // The even numbers would be deleted
            if (numbers[prime]) { // Then only the odd numbers will be checked
                for (int i=prime; i<=max/prime; i++){
                    final int multipliedSum = i * prime;
                    if (multipliedSum < max){ // Preventing overflow
                        numbers[multipliedSum] = false; // deleted
                    }
                }
            }
        }

        // Export the found prime
        int count = 0;
        for (boolean isPrime : numbers){
            if (isPrime)
                count++;
        }
        // Prime list
        int[] primeNumbers = new int[count];
        int index = 0;
        for (int i=0; i<numbers.length; i++){
            if (numbers[i]){
                primeNumbers[index] = i;
                index++;
            }
        }
        // Set the first prime
        primeNumbers[0] = 2;
        return primeNumbers;
    }

    public static void main(String[] args) {

        System.out.println("Sieve of Eratosthenes - Test: ");
        int i = 1;

        for (int prime : eratosthenes(args.length > 0 ? Integer.parseInt(args[0]) : 1000)) {
            System.out.print(prime + ", ");
            if((i++) % 10 == 0)
                System.out.println();
        }
    }
}