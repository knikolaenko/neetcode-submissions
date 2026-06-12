class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i=0; i<students.length; i++) {
            queue.add(students[i]);
        }
        for (int i=0; i<sandwiches.length; i++) {
            int sandwich = sandwiches[i];
            int student = queue.poll();
            int counter = 1;
            while (student != sandwich) {
                if (counter > sandwiches.length - i) {
                    return sandwiches.length - i;
                }
                queue.add(student);
                student = queue.poll();
                counter++;
            }
        }
        return 0;
    }
}