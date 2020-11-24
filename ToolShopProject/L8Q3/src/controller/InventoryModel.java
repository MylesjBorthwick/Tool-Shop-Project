package controller;
import java.io.Serializable;

/**
 *   
 *
 */
class InventoryModel implements Serializable
	{

		private static final long serialVersionUID = 1L;
		private String query = null;
		private String response = null;
		private boolean answered = false;


    public InventoryModel(){
      
    }

        /**
         * A default constructor that builds a record with blank data
         */
		public InventoryModel(String query) {
			this.query = query;
		} 
	
    /**
     * @return String return the query
     */
    public String getQuery() {
        return query;
    }

    /**
     * @param query the query to set
     */
    public void setQuery(String query) {
		this.query = query;
		this.answered = false;
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


}
