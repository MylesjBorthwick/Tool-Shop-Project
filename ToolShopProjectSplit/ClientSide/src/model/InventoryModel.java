package model;
import java.io.Serializable;

/**
 * This class is the model that will store the information for the queries that will be sent from the frontend to the backend
 * for the inventory Model. Query id is set to get the response from the backend, and is encoded as follows:
 * 1: display all the tools
 * 2: tool information by tool name
 * 3: tool information by tool id
 * 4: tool quantity by tool name
 * 5: decrease tool quantity
 * 6: display order information
 * @author Myles Borthwick
 * @author Ken Loughery
 * @since Nov, 2020
 */

public class InventoryModel implements Serializable
	{

    private static final long serialVersionUID = 1L;
    private int queryId;
    private int id;
	private String toolName;
	private String response;
	private boolean answered;

    /**
     * default constructor that sets all the fields to default configurations
     */
    public InventoryModel(){
        queryId = -1;
        id = 0;
        toolName = null;
        response = null;
        answered = false;    
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
