package io.richie;

/**
 * Pretend that this service is used to makes donations.
 */
public interface ContributionService {

    /**
     * Places a contribution into some data store
     * @param amount the amount of money you wanna contribute
     * @return the RESTFUL status code
     */
    int makeContribution(double amount);

    /**
     * Places a contribution into some data store
     * @param id the id of the contribution you wanna cancel
     * @return the RESTFUL status code
     */
    int cancelContribution(int id);

}
