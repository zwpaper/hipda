package net.jejer.hipda.bean;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.preference.PreferenceManager;
import android.text.TextUtils;

import net.jejer.hipda.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public class HiSettingsHelper {
    /*
     *
     * NOTE! PLEASE LINE-UP WITH PREFERENCE.XML
     *
     * */
    public static final String PERF_USERNAME = "PERF_USERNAME";
    public static final String PERF_PASSWORD = "PERF_PASSWORD";
    public static final String PERF_SECQUESTION = "PERF_SECQUESTION";
    public static final String PERF_SECANSWER = "PERF_SECANSWER";
    public static final String PERF_COOKIEAUTH = "PERF_COOKIEAUTH";
    public static final String PERF_SHOWSTICKTHREADS = "PERF_SHOWSTICKTHREADS";
    public static final String PERF_LOADIMGONMOBILENWK = "PERF_LOADIMGONMOBILENWK";
    public static final String PERF_THREADLISTAVATAR = "PERF_THREADLISTAVATAR";
    public static final String PERF_PREFETCH = "PERF_PREFETCH";
    public static final String PERF_SORTBYPOSTTIME = "PERF_SORTBYPOSTTIME";
    public static final String PERF_POST_REDIRECT = "PERF_POST_REDIRECT";
    public static final String PERF_ADDTAIL = "PERF_ADDTAIL";
    public static final String PERF_TAILTEXT = "PERF_TAILTEXT";
    public static final String PERF_TAILURL = "PERF_TAILURL";
    public static final String PERF_NIGHTTHEME = "PERF_NIGHTTHEME";
    public static final String PERF_ENCODEUTF8 = "PERF_ENCODEUTF8";
    public static final String PERF_EINK_MODE = "PERF_EINK_MODE";
    public static final String PERF_TITLE_BOLD = "PERF_TITLE_BOLD";
    public static final String PERF_BLANKLIST_USERNAMES = "PERF_BLANKLIST_USERNAMES";
    public static final String PERF_TEXTSIZE_POST_ADJ = "PERF_TEXTSIZE_POST_ADJ";
    public static final String PERF_TEXTSIZE_TITLE_ADJ = "PERF_TEXTSIZE_TITLE_ADJ";
    public static final String PERF_SCREEN_ORIENTATION = "PERF_SCREEN_ORIENTATION";
    public static final String PERF_GESTURE_BACK = "PERF_GESTURE_BACK";
    public static final String PERF_LAST_UPDATE_CHECK = "PERF_LAST_UPDATE_CHECK";
    public static final String PERF_AUTO_UPDATE_CHECK = "PERF_AUTO_UPDATE_CHECK";
    public static final String PERF_ABOUT = "PERF_ABOUT";
    public static final String PERF_MAX_POSTS_IN_PAGE = "PERF_MAX_POSTS_IN_PAGE";
    public static final String PERF_POST_LINE_SPACING = "PERF_POST_LINE_SPACING";


    private Context mCtx;
    private SharedPreferences mSharedPref;

    private String mUsername = "";
    private String mPassword = "";
    private String mSecQuestion = "";
    private String mSecAnswer = "";

    private String mCookieAuth = "";

    private boolean mShowStickThreads = false;
    private boolean mLoadImgOnMobileNwk = true;
    private boolean mPreFetch = true;
    private boolean mSortByPostTime = false;
    private boolean mShowThreadListAvatar = true;
    private boolean mPostRedirect = true;

    private boolean mAddTail = true;
    private String mTailText = "";
    private String mTailUrl = "";

    private boolean mNightTheme = false;

    private boolean mEncodeUtf8 = false;
    private Set<String> mEinkMode = new HashSet<String>();
    private int mTitleBold;

    private String[] mBlanklistUsernames = null;

    private String mPostTextSizeAdj = "";
    private int mPostLineSpacing = 0;
    private String mTitleTextSizeAdj = "";
    private int mScreenOrientation = ActivityInfo.SCREEN_ORIENTATION_USER;
    private boolean mGestureBack = true;
    private int mMaxPostsInPage;
    private String mHiPdaColorValue;

    // --------------- THIS IS NOT IN PERF -----------
    private boolean mIsLandscape = false;

    public void setIsLandscape(boolean landscape) {
        mIsLandscape = landscape;
    }

    public boolean getIsLandscape() {
        return mIsLandscape;
    }

    // --------------- THIS IS NOT IN PERF -----------


    private HiSettingsHelper() {
    }

    private static class SingletonHolder {
        public static final HiSettingsHelper INSTANCE = new HiSettingsHelper();
    }

    public static HiSettingsHelper getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public void init(Context ctx) {
        mCtx = ctx;
        mSharedPref = PreferenceManager.getDefaultSharedPreferences(mCtx);
        reload();
    }

    public void reload() {
        getUsernameFromPref();
        getPasswordFromPref();
        getSecQuestionFromPref();
        getSecAnswerFromPref();
        getCookieAuthFromPref();
        isShowStickThreadsFromPref();
        isLoadImgOnMobileNwkFromPref();
        isShowThreadListAvatarFromPref();
        isPreFetchFromPref();
        isSortByPostTimeFromPref();
        isAddTailFromPref();
        getTailTextFromPref();
        getTailUrlFromPref();
        isNightThemeFromPref();
        isEncodeUtf8FromPref();
        getEinkModeFromPref();
        getBlanklistUsernamesFromPref();
        getPostTextsizeAdjFromPref();
        getTitleTextsizeAdjFromPref();
        getScreenOrietationFromPref();
        isGestureBackFromPref();
        isPostRedirectFromPref();
        getTitleBoldFromPref();
        getPostLineSpacingFromPref();
    }

    public boolean isLoginInfoValid() {
        return (!mUsername.isEmpty() && !mPassword.isEmpty());
    }

    public String getUsername() {
        return mUsername;
    }

    public String getUsernameFromPref() {
        mUsername = mSharedPref.getString(PERF_USERNAME, "");
        return mUsername;
    }

    public void setUsername(String username) {
        mUsername = username;
        SharedPreferences.Editor editor = mSharedPref.edit();
        editor.putString(PERF_USERNAME, username).commit();
    }

    public String getPassword() {
        return mPassword;
    }

    public String getPasswordFromPref() {
        mPassword = mSharedPref.getString(PERF_PASSWORD, "");
        return mPassword;
    }

    public void setPassword(String password) {
        mPassword = password;
        SharedPreferences.Editor editor = mSharedPref.edit();
        editor.putString(PERF_PASSWORD, password).commit();
    }

    public String getSecQuestion() {
        return mSecQuestion;
    }

    public String getSecQuestionFromPref() {
        mSecQuestion = mSharedPref.getString(PERF_SECQUESTION, "");
        return mSecQuestion;
    }

    public void setSecQuestion(String secQuestion) {
        mSecQuestion = secQuestion;
        SharedPreferences.Editor editor = mSharedPref.edit();
        editor.putString(PERF_SECQUESTION, secQuestion).commit();
    }

    public String getSecAnswer() {
        return mSecAnswer;
    }

    public String getSecAnswerFromPref() {
        mSecAnswer = mSharedPref.getString(PERF_SECANSWER, "");
        return mSecAnswer;
    }

    public void setSecAnswer(String secAnswer) {
        mSecAnswer = secAnswer;
        SharedPreferences.Editor editor = mSharedPref.edit();
        editor.putString(PERF_SECANSWER, secAnswer).commit();
    }

    public String getCookieAuth() {
        return mCookieAuth;
    }

    public String getCookieAuthFromPref() {
        mCookieAuth = mSharedPref.getString(PERF_COOKIEAUTH, "");
        return mCookieAuth;
    }

    public void setCookieAuth(String cookieAuth) {
        mCookieAuth = cookieAuth;
        SharedPreferences.Editor editor = mSharedPref.edit();
        editor.putString(PERF_COOKIEAUTH, cookieAuth).commit();
    }

    public boolean isShowStickThreads() {
        return mShowStickThreads;
    }

    public boolean isShowStickThreadsFromPref() {
        mShowStickThreads = mSharedPref.getBoolean(PERF_SHOWSTICKTHREADS, false);
        return mShowStickThreads;
    }

    public void setShowStickThreads(boolean showStickThreads) {
        mShowStickThreads = showStickThreads;
        SharedPreferences.Editor editor = mSharedPref.edit();
        editor.putBoolean(PERF_SHOWSTICKTHREADS, showStickThreads).commit();
    }

    public boolean isShowThreadListAvatar() {
        return mShowThreadListAvatar;
    }

    public boolean isShowThreadListAvatarFromPref() {
        mShowThreadListAvatar = mSharedPref.getBoolean(PERF_THREADLISTAVATAR, true);
        return mShowThreadListAvatar;
    }

    public void setShowThreadListAvatar(boolean showThreadListAvatar) {
        mShowThreadListAvatar = showThreadListAvatar;
        SharedPreferences.Editor editor = mSharedPref.edit();
        editor.putBoolean(PERF_THREADLISTAVATAR, showThreadListAvatar).commit();
    }

    public boolean isLoadImgOnMobileNwk() {
        return mLoadImgOnMobileNwk;
    }

    public boolean isLoadImgOnMobileNwkFromPref() {
        mLoadImgOnMobileNwk = mSharedPref.getBoolean(PERF_LOADIMGONMOBILENWK, true);
        return mLoadImgOnMobileNwk;
    }

    public void setLoadImgOnMobileNwk(boolean loadImgOnMobileNwk) {
        mLoadImgOnMobileNwk = loadImgOnMobileNwk;
        SharedPreferences.Editor editor = mSharedPref.edit();
        editor.putBoolean(PERF_LOADIMGONMOBILENWK, loadImgOnMobileNwk).commit();
    }

    public boolean isPreFetch() {
        return mPreFetch;
    }

    public boolean isPreFetchFromPref() {
        mPreFetch = mSharedPref.getBoolean(PERF_PREFETCH, true);
        return mPreFetch;
    }

    public void setPreFetch(boolean preFetch) {
        mPreFetch = preFetch;
        SharedPreferences.Editor editor = mSharedPref.edit();
        editor.putBoolean(PERF_PREFETCH, preFetch).commit();
    }

    public boolean isSortByPostTime() {
        return mSortByPostTime;
    }

    public boolean isSortByPostTimeFromPref() {
        mSortByPostTime = mSharedPref.getBoolean(PERF_SORTBYPOSTTIME, false);
        return mSortByPostTime;
    }

    public void setSortByPostTime(boolean sortByPostTime) {
        mSortByPostTime = sortByPostTime;
        SharedPreferences.Editor editor = mSharedPref.edit();
        editor.putBoolean(PERF_SORTBYPOSTTIME, sortByPostTime).commit();
    }

    public boolean isPostReirect() {
        return mPostRedirect;
    }

    public boolean isPostRedirectFromPref() {
        mPostRedirect = mSharedPref.getBoolean(PERF_POST_REDIRECT, true);
        return mPostRedirect;
    }

    public void setPostRedirect(boolean postRedirect) {
        mPostRedirect = postRedirect;
        SharedPreferences.Editor editor = mSharedPref.edit();
        editor.putBoolean(PERF_POST_REDIRECT, postRedirect).apply();
    }

    public boolean isAddTail() {
        return mAddTail;
    }

    public boolean isAddTailFromPref() {
        mAddTail = mSharedPref.getBoolean(PERF_ADDTAIL, true);
        return mAddTail;
    }

    public void setAddTail(boolean addTail) {
        mAddTail = addTail;
        SharedPreferences.Editor editor = mSharedPref.edit();
        editor.putBoolean(PERF_ADDTAIL, addTail).commit();
    }

    public String getTailText() {
        return mTailText;
    }

    public String getTailTextFromPref() {
        mTailText = mSharedPref.getString(PERF_TAILTEXT, "");
        return mTailText;
    }

    public void setTailText(String tailText) {
        mTailText = tailText;
        SharedPreferences.Editor editor = mSharedPref.edit();
        editor.putString(PERF_TAILTEXT, tailText).commit();
    }

    public String getTailUrl() {
        return mTailUrl;
    }

    public String getTailUrlFromPref() {
        mTailUrl = mSharedPref.getString(PERF_TAILURL, "");
        return mTailUrl;
    }

    public void setTailUrl(String tailUrl) {
        mTailUrl = tailUrl;
        SharedPreferences.Editor editor = mSharedPref.edit();
        editor.putString(PERF_TAILURL, tailUrl).commit();
    }

    public boolean isNightTheme() {
        return mNightTheme;
    }

    public boolean isNightThemeFromPref() {
        mNightTheme = mSharedPref.getBoolean(PERF_NIGHTTHEME, false);
        return mNightTheme;
    }

    public void setNightTheme(boolean nightTheme) {
        mNightTheme = nightTheme;
        SharedPreferences.Editor editor = mSharedPref.edit();
        editor.putBoolean(PERF_NIGHTTHEME, nightTheme).commit();
    }

    public boolean isEncodeUtf8() {
        return mEncodeUtf8;
    }

    public boolean isEncodeUtf8FromPref() {
        mEncodeUtf8 = mSharedPref.getBoolean(PERF_ENCODEUTF8, false);
        return mEncodeUtf8;
    }

    public void setEncodeUtf8(boolean encodeUtf8) {
        mEncodeUtf8 = encodeUtf8;
        SharedPreferences.Editor editor = mSharedPref.edit();
        editor.putBoolean(PERF_ENCODEUTF8, encodeUtf8).commit();
    }

    public String getEncode() {
        if (mEncodeUtf8) {
            return "UTF-8";
        } else {
            return "GBK";
        }
    }

    public Set<String> getEinkMode() {
        return mEinkMode;
    }

    public Set<String> getEinkModeFromPref() {
        mEinkMode = mSharedPref.getStringSet(PERF_EINK_MODE, new HashSet<String>());
        return mEinkMode;
    }

    public void setEinkMode(Set<String> einkMode) {
        mEinkMode = einkMode;
        SharedPreferences.Editor editor = mSharedPref.edit();
        editor.putStringSet(PERF_EINK_MODE, einkMode).commit();
    }

    public int getTitleBold() {
        return mTitleBold;
    }

    public void setTitleBold(int titleBold) {
        mTitleBold = titleBold;
        SharedPreferences.Editor editor = mSharedPref.edit();
        editor.putString(PERF_TITLE_BOLD, titleBold + "").commit();
    }

    public int getTitleBoldFromPref() {
        String strTitleBold = mSharedPref.getString(PERF_TITLE_BOLD, "0");
        if (TextUtils.isDigitsOnly(strTitleBold)) {
            mTitleBold = Integer.parseInt(strTitleBold);
        } else {
            mTitleBold = 0;
        }
        return mTitleBold;
    }

    public String[] getBlanklistUsernames() {
        return mBlanklistUsernames;
    }

    public String[] getBlanklistUsernamesFromPref() {
        mBlanklistUsernames = mSharedPref.getString(PERF_BLANKLIST_USERNAMES, "").split(" ");
        return mBlanklistUsernames;
    }

    public void setBlanklistUsernames(String blanklistUsernames) {
        mBlanklistUsernames = blanklistUsernames.split(" ");
        SharedPreferences.Editor editor = mSharedPref.edit();
        editor.putString(PERF_BLANKLIST_USERNAMES, blanklistUsernames).commit();
    }

    public boolean isUserBlack(String username) {
        for (String s : mBlanklistUsernames) {
            if (s.equals(username)) {
                return true;
            }
        }
        return false;
    }

    public int getPostTextsizeAdj() {
        return Integer.parseInt(mPostTextSizeAdj);
    }

    public String getPostTextsizeAdjFromPref() {
        mPostTextSizeAdj = mSharedPref.getString(PERF_TEXTSIZE_POST_ADJ, "0");
        return mPostTextSizeAdj;
    }

    public void setPostTextsizeAdj(String adj) {
        mPostTextSizeAdj = adj;
        SharedPreferences.Editor editor = mSharedPref.edit();
        editor.putString(PERF_TEXTSIZE_POST_ADJ, adj).commit();
    }


    public void setPostLineSpacing(int lineSpacing) {
        mPostLineSpacing = lineSpacing;
        SharedPreferences.Editor editor = mSharedPref.edit();
        editor.putString(PERF_POST_LINE_SPACING, lineSpacing + "").commit();
    }

    public int getPostLineSpacing() {
        return mPostLineSpacing;
    }

    public int getPostLineSpacingFromPref() {
        String value = mSharedPref.getString(PERF_POST_LINE_SPACING, "0");
        if (TextUtils.isDigitsOnly(value)) {
            mPostLineSpacing = Integer.parseInt(value);
        }
        return mPostLineSpacing;
    }

    public int getTitleTextsizeAdj() {
        return Integer.parseInt(mTitleTextSizeAdj);
    }

    public String getTitleTextsizeAdjFromPref() {
        mTitleTextSizeAdj = mSharedPref.getString(PERF_TEXTSIZE_TITLE_ADJ, "0");
        return mTitleTextSizeAdj;
    }

    public void setTitleTextsizeAdj(String adj) {
        mPostTextSizeAdj = adj;
        SharedPreferences.Editor editor = mSharedPref.edit();
        editor.putString(PERF_TEXTSIZE_TITLE_ADJ, adj).commit();
    }

    public int getScreenOrietation() {
        return mScreenOrientation;
    }

    public int getScreenOrietationFromPref() {
        try {
            mScreenOrientation = Integer.parseInt(mSharedPref.getString(PERF_SCREEN_ORIENTATION, ActivityInfo.SCREEN_ORIENTATION_USER + ""));
        } catch (Exception e) {
            mScreenOrientation = ActivityInfo.SCREEN_ORIENTATION_USER;
        }
        return mScreenOrientation;
    }

    public void setScreenOrietation(int screenOrientation) {
        mScreenOrientation = screenOrientation;
        SharedPreferences.Editor editor = mSharedPref.edit();
        editor.putString(PERF_SCREEN_ORIENTATION, mScreenOrientation + "").commit();
    }

    public boolean isGestureBack() {
        return mGestureBack;
    }

    public boolean isGestureBackFromPref() {
        mGestureBack = mSharedPref.getBoolean(PERF_GESTURE_BACK, false);
        return mGestureBack;
    }

    public void setGestureBack(boolean gestureBack) {
        mGestureBack = gestureBack;
        SharedPreferences.Editor editor = mSharedPref.edit();
        editor.putBoolean(PERF_GESTURE_BACK, gestureBack).commit();
    }

    public Date getLastUpdateCheckTime() {
        String millis = mSharedPref.getString(PERF_LAST_UPDATE_CHECK, "");
        if (millis.length() > 0) {
            try {
                return new Date(Long.parseLong(millis));
            } catch (Exception ignored) {
            }
        }
        return null;
    }

    public void setLastUpdateCheckTime(Date d) {
        SharedPreferences.Editor editor = mSharedPref.edit();
        editor.putString(HiSettingsHelper.PERF_LAST_UPDATE_CHECK, d.getTime() + "").apply();
    }

    public void setAutoUpdateCheck(boolean b) {
        SharedPreferences.Editor editor = mSharedPref.edit();
        editor.putBoolean(HiSettingsHelper.PERF_AUTO_UPDATE_CHECK, b).apply();
    }

    public boolean isAutoUpdateCheck() {
        return mSharedPref.getBoolean(PERF_AUTO_UPDATE_CHECK, true);
    }

    public int getMaxPostsInPage() {
        if (mMaxPostsInPage <= 0) {
            mMaxPostsInPage = mSharedPref.getInt(PERF_MAX_POSTS_IN_PAGE, 0);
        }
        return mMaxPostsInPage;
    }

    public void setMaxPostsInPage(int maxPostsInPage) {
        //could be 5,10,15 default is 50
        if (maxPostsInPage > 0 && maxPostsInPage % 5 == 0 && maxPostsInPage != mMaxPostsInPage) {
            mMaxPostsInPage = maxPostsInPage;
            SharedPreferences.Editor editor = mSharedPref.edit();
            editor.putInt(HiSettingsHelper.PERF_MAX_POSTS_IN_PAGE, mMaxPostsInPage).apply();
        }
    }

    public boolean isUpdateCheckable() {
        if (!isAutoUpdateCheck())
            return false;
        Date now = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        Date lastCheck = HiSettingsHelper.getInstance().getLastUpdateCheckTime();
        return lastCheck == null || !formatter.format(now).equals(formatter.format(lastCheck));
    }

    public String getAppVersion() {
        String version = "0.0.00";
        try {
            version = mCtx.getPackageManager().getPackageInfo(mCtx.getPackageName(), 0).versionName;
        } catch (Exception ignored) {
        }
        return version;
    }

    public static int getPostTextSize() {
        return 17 + getInstance().getPostTextsizeAdj();
    }

    public static int getTitleTextSize() {
        return 18 + getInstance().getTitleTextsizeAdj();
    }

    public boolean isEinkModeUIEnabled() {
        return getEinkMode().contains("1");
    }


    public boolean isEinkModeFloatButtonEnabled() {
        return getEinkMode().contains("2");
    }

    public boolean isEinkModeVolumeKeyEnabled() {
        return getEinkMode().contains("3");
    }

    @SuppressWarnings("ResourceType")
    public String getHiPdaColorValue() {
        if (mHiPdaColorValue == null) {
            if (isEinkModeUIEnabled())
                mHiPdaColorValue = mCtx.getResources().getString(R.color.black);
            else
                mHiPdaColorValue = mCtx.getResources().getString(R.color.hipda);
            if (mHiPdaColorValue.length() == 9) {
                mHiPdaColorValue = "#" + mHiPdaColorValue.substring(3);
            }
        }
        return mHiPdaColorValue;
    }

}
