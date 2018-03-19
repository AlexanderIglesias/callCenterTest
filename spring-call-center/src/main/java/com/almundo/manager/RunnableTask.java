package com.almundo.manager;


import com.almundo.model.EmployedDTO;

public class RunnableTask extends Thread {

    private EmployedDTO employed;

    public RunnableTask(final EmployedDTO employed){
        this.employed = employed;
    }

    /**
     * Method that processes a call
     */
    @Override
    public void run() {
        System.out.println("Initiating call with: "+employed.getName());
        // Process task here
        long initialTime = System.currentTimeMillis();
        try {
            //random call duration in range 1/10
            int callDuration = ((int)(Math.random() * 10) + 1);
            //stop call with the call duration
            Thread.sleep(callDuration * 1000);
            //enable current employed
            employed = new EmployedDTO.Builder(employed.getName(), employed.getType(),true).build();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //print call duration time in seg
        System.out.println("Ending call with: "+employed.getName()+" on "+
                (System.currentTimeMillis() - initialTime) / 1000
                + "seg");
    }
}