// Import the necessary libraries
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.reward.RewardItem
import com.google.android.gms.ads.reward.RewardedVideoAd
import com.google.android.gms.ads.reward.RewardedVideoAdListener

class MainActivity : AppCompatActivity(), RewardedVideoAdListener {

    // Initialize the rewarded video ad
    private lateinit var rewardedVideoAd: RewardedVideoAd
    
    // Initialize the AdRequest
    private lateinit var adRequest: AdRequest
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize the Mobile Ads SDK
        MobileAds.initialize(this) { }
        
        // Load the rewarded video ad
        rewardedVideoAd = MobileAds.getRewardedVideoAdInstance(this)
        rewardedVideoAd.rewardedVideoAdListener = this
        loadRewardedVideoAd()
    }

    // Function to load the rewarded video ad
    private fun loadRewardedVideoAd() {
        adRequest = AdRequest.Builder().build()
        rewardedVideoAd.loadAd("ca-app-pub-3940256099942544/5224354917", adRequest)
    }

    // Function to show the rewarded video ad
    fun showRewardedVideoAd() {
        if (rewardedVideoAd.isLoaded) {
            rewardedVideoAd.show()
        } else {
            loadRewardedVideoAd()
        }
    }
    
    // Override functions for the RewardedVideoAdListener
    override fun onRewardedVideoAdLoaded() {
        // Code to be executed when the ad is loaded
    }
    
    override fun onRewardedVideoAdOpened() {
        // Code to be executed when the ad is opened
    }
    
    override fun onRewarded(reward: RewardItem) {
        // Code to be executed when the user is rewarded
    }
    
    override fun onRewardedVideoStarted() {
        // Code to be executed when the ad starts playing
    }
    
    override fun onRewardedVideoAdClosed() {
        // Code to be executed when the ad is closed
        loadRewardedVideoAd()
    }
    
    override fun onRewardedVideoAdLeftApplication() {
        // Code to be executed when the user leaves the application
    }
    
    override fun onRewardedVideoAdFailedToLoad(errorCode: Int) {
        // Code to be executed when the ad fails to load
    }
}
