package auctionsniper;

import static auctionsniper.FakeAuctionServer.XMPP_HOSTNAME;
import static auctionsniper.Main.STATUS_JOINING;
import static auctionsniper.Main.STATUS_LOST;

public class ApplicationRunner {

    private static final String SNIPER_ID = "sniper";
    private static final String SNIPER_PASSWORD = "sniper";

    private AuctionSniperDriver driver;

    public void startBiddingIn(final FakeAuctionServer auction) {
        Thread thread = new Thread("Test Application") {
            @Override
            public void run() {
                try {
                    Main.main(XMPP_HOSTNAME, SNIPER_ID, SNIPER_PASSWORD, auction.getItemId());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

        thread.setDaemon(true);
        thread.start();

        driver = new AuctionSniperDriver(1000);
        driver.showsSniperStatus(STATUS_JOINING);
    }

    public void showsSniperHasLostAuction() throws InterruptedException {
        Thread.sleep(500);
        driver.showsSniperStatus(STATUS_LOST);
    }

    public void stop() {

    }
}
