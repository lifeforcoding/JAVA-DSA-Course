public int canCompleteCircuit(int[] gas, int[] cost) {
        int balance = 0;
        int deficit = 0;
        int start = 0;
        for (int i = 0; i < gas.length; i++) {
            balance += gas[i] - cost[i];
            /*If we travel certain distance and can't move forward from that point to the next point
            due to the deficiency of the gas , then at that case the deficiency gas value which is less than zero, is
            stored in the deficit variable. The logic behind this is, when we came to this range from another starting point
            then we don't have to calculate the balance of this distance simple add deficit to that balance.
            If the balance is >= 0 then it is circular and return the start otherwise return -1;*/
            if (balance < 0) {
                deficit += balance;
                start = i + 1;
                balance = 0;
            }
        }
        balance += deficit;
        if (balance < 0)
            return -1;
        else return start;
    }
