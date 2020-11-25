package controller;
import java.io.Serializable;

/**
 *   
 *
 */
public class InventoryModel implements Serializable
	{

    private static final long serialVersionUID = 1L;
    private int queryId = 0;
    private int id = 0;
		private String toolName = null;
		private String response = null;
		private boolean answered = false;


    public InventoryModel(){
      
    }

        /**
         * A default constructor that builds a record with blank data
         */
		public InventoryModel(int queryId) {
			this.queryId = queryId;
		} 

    /**
     * @return String return the response
     */
    public String getResponse() {
        return response;
    }

    /**
     * @param response the response to set
     */
    public void setResponse(String response) {
		this.response = response;
		this.answered = true;
    }

    /**
     * @return boolean return the answered
     */
    public boolean isAnswered() {
        return answered;
    }

    /**
     * @param answered the answered to set
     */
    public void setAnswered(boolean answered) {
        this.answered = answered;
    }



    /**
     * @return int return the queryId
     */
    public int getQueryId() {
        return queryId;
    }

    /**
     * @param queryId the queryId to set
     */
    public void setQueryId(int queryId) {
        this.queryId = queryId;
        this.answered = false;
    }

    /**
     * @return String return the toolName
     */
    public String getToolName() {
        return toolName;
    }

    /**
     * @param toolName the toolName to set
     */
    public void setToolName(String toolName) {
        this.toolName = toolName;
    }


    /**
     * @return int return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

}
