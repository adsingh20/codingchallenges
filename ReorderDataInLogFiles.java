class Solution {
    public String[] reorderLogFiles(String[] logs) {
        if(logs == null || logs.length ==0) return logs;
        List<String> numericList = new ArrayList<>();
        List<String> alphaList = new ArrayList<>();
        for (String log : logs){
            if (Character.isDigit(log.split(" ")[1].charAt(0)))
                numericList.add(log);
            else 
                alphaList.add(log);
        }
        
        Collections.sort(alphaList, (d1, d2) -> {
           String[] s1 = d1.split(" "); 
           String[] s2 = d2.split(" ");
           for(int i = 1; i < Math.min(s1.length, s2.length); i++){
               if(!s1[i].equals(s2[i])){
                   return s1[i].compareTo(s2[i]);
               }
           }
        return s1[0].compareTo(s2[0]);
        });
        
        for (int i = 0; i < logs.length; i++) {
            if (i < alphaList.size())
                logs[i] = alphaList.get(i);
            else logs[i] = numericList.get(i - alphaList.size());
        }
        return logs;
    }  
    
}
