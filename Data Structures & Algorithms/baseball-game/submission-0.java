class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> scores = new Stack<>();
        int totalScore = 0;
        for (int i=0; i<operations.length; i++) {
            String operation = operations[i];
            if ("+".equals(operation)) {
                Integer last = scores.pop();
                Integer newScore = last + scores.peek();
                scores.push(last);
                scores.push(newScore);
                totalScore += newScore;
            } else if ("D".equals(operation)) {
                Integer newScore = scores.peek() * 2;
                scores.push(newScore);
                totalScore += newScore;
            } else if ("C".equals(operation)) {
                Integer last = scores.pop();
                totalScore -= last;
            } else {
                Integer newScore = Integer.valueOf(operation);
                scores.push(newScore);
                totalScore += newScore;
            }
        }
        return totalScore;
    }
}