package com.start.apps.pheezee.retrofit;

import com.start.apps.pheezee.pojos.AccessTokenRequestBody;
import com.start.apps.pheezee.pojos.AddPatientData;
import com.start.apps.pheezee.pojos.CommentSessionUpdateData;
import com.start.apps.pheezee.pojos.ConfirmEmailAndPackageId;
import com.start.apps.pheezee.pojos.DeletePatientData;
import com.start.apps.pheezee.pojos.DeletePhiziouserData;
import com.start.apps.pheezee.pojos.DeleteSessionData;
import com.start.apps.pheezee.pojos.DeviceDeactivationStatus;
import com.start.apps.pheezee.pojos.DeviceDeactivationStatusResponse;
import com.start.apps.pheezee.pojos.DeviceDetailsData;
import com.start.apps.pheezee.pojos.DeviceLocationStatus;
import com.start.apps.pheezee.pojos.FirmwareData;
import com.start.apps.pheezee.pojos.FirmwareUpdateCheck;
import com.start.apps.pheezee.pojos.FirmwareUpdateCheckResponse;
import com.start.apps.pheezee.pojos.ForgotPassword;
import com.start.apps.pheezee.pojos.GetReportData;
import com.start.apps.pheezee.pojos.GetReportDataResponse;
import com.start.apps.pheezee.pojos.HealthData;
import com.start.apps.pheezee.pojos.LoginData;
import com.start.apps.pheezee.pojos.LoginResp;
import com.start.apps.pheezee.pojos.LoginResult;
import com.start.apps.pheezee.pojos.MmtData;
import com.start.apps.pheezee.pojos.MobileToken;
import com.start.apps.pheezee.pojos.Overallresponse;
import com.start.apps.pheezee.pojos.PatientDetailsData;
import com.start.apps.pheezee.pojos.PatientImageData;
import com.start.apps.pheezee.pojos.PatientImageUploadResponse;
import com.start.apps.pheezee.pojos.PatientStatusData;
import com.start.apps.pheezee.pojos.PhizioDetailsData;
import com.start.apps.pheezee.pojos.PhizioEmailData;
import com.start.apps.pheezee.pojos.PhizioSessionReportData;
import com.start.apps.pheezee.pojos.RefreshAccessTokenResponse;
import com.start.apps.pheezee.pojos.ResponseData;
import com.start.apps.pheezee.pojos.SceduledSessionNotSaved;
import com.start.apps.pheezee.pojos.SerialData;
import com.start.apps.pheezee.pojos.SessionData;
import com.start.apps.pheezee.pojos.SessionDetailsResult;
import com.start.apps.pheezee.pojos.SignUpData;
import com.start.apps.pheezee.pojos.SignupResult;
import com.start.apps.pheezee.pojos.WarrantyData;
import com.start.apps.pheezee.room.Entity.MqttSync;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.Url;

/**
 *
 */
public interface GetDataService {
    @GET
    Call<ResponseBody> getReport(@Url String url);

    @POST("/v3/auth/refresh-token")
    Call<RefreshAccessTokenResponse> fetchRefreshToken(@Body AccessTokenRequestBody refreshToken);


    @POST("/v3/auth/login")
    Call<List<LoginResult>> login(@Body LoginData object);

    @POST("/v3/phiziopatient/update-patient-status")
    Call<String> updatePatientStatus(@Body PatientStatusData object);

    @POST("/v3/phiziopatient/update-patient-details")
    Call<String> updatePatientDetails(@Body PatientDetailsData patient);

    @POST("/v3/phiziopatient/add-patient")
    Call<ResponseData> addPatient(@Body AddPatientData patientData);

    @POST("/v3/phiziopatient/delete-patient")
    Call<String> deletePatient(@Body DeletePatientData data);


    @POST("/v3/auth/forgot-password")
    Call<String> forgotPassword(@Body ForgotPassword object);


    @POST("/v3/phiziouser/update-app-version")
    Call<String> updateApp_version(@Body LoginData data, @Header("Authorization") String accessToken);

    @POST("/v3/phiziosession/getheldon")
    Call<String> getHeldon(@Body PatientStatusData object);

    @POST("/v3/phiziosession/get-session-report-count")
    Call<PhizioSessionReportData> getsession_report_count(@Body PatientStatusData object);

    @POST("/v3/phiziosession/get-session-number-count")
    Call<PhizioSessionReportData> getsession_number_count(@Body PatientStatusData object);

    @POST("v3/phiziosession/get-overall-details")
    Call<Overallresponse> getOverall_list(@Body PatientStatusData object);

    @POST("/v3/phiziosession/get-session-details")
    Call <List<SessionDetailsResult>> getSessiondetails(@Body PatientStatusData object);

    @POST("/v3/auth/send-verification-email")
    Call<String> sendVerificationEmail(@Body ConfirmEmailAndPackageId object);

    @POST("/v3/auth/verify-email")
    Call<String> verifyEmail(@Query("token") String token);

    @POST("/v3/auth/reset-password")
    Call<String> resetPassword(@Query("token") String token,@Body LoginResp data);

    @POST("/v3/auth/register")
    Call<List<SignupResult>> signUp(@Body SignUpData data);

    @POST("/v3/phiziopatient/update-patient-profile-pic")
    Call<PatientImageUploadResponse> uploadPatientProfilePicture(@Body PatientImageData data);

    @POST("/v3/phiziouser/update-profile")
    Call<String> updatePhizioDetails(@Body PhizioDetailsData data,@Header("Authorization") String accessToken);

    @POST("v3/phiziouser/upload-profile-pic")
    Call<PatientImageUploadResponse> updatePhizioProfilePic(@Body PatientImageData data);

    @POST("v3/phiziouser/upload-clinic-logo")
    Call<PatientImageUploadResponse> updatePhizioClinicLogoPic(@Body PatientImageData data);

    @POST("/v3/phiziosession/patient-generate-report-v2")
    Call<GetReportDataResponse> getReportData(@Body GetReportData data);


    @POST("/v3/phiziosession/patient-entire-emg-data")
    Call<ResponseData> insertSessionData(@Body SessionData data);

    @POST("/v3/phiziosession/delete-patient-session")
    Call<ResponseData> deletePatientSession(@Body DeleteSessionData data);

    @POST("/v3/phiziosession/update-mmt-grade")
    Call<ResponseData> updateMmtData(@Body MmtData data);

    @POST("/v3/phiziosession/update-comment-section")
    Call<String> updateCommentData(@Body CommentSessionUpdateData data);

    @POST("/v3/phiziomisc/sync-data-on-server")
    Call<List<Integer>> syncDataToServer(@Body List<MqttSync> sync);

    @POST("/v3/phiziomisc/firmware-log")
    Call<Boolean> sendFirmwareLog(@Body FirmwareData log);

    @POST("/v3/phiziomisc/firmware-update-check-and-send")
    Call<FirmwareUpdateCheckResponse> checkFirmwareUpdateAndGetLink(@Body FirmwareUpdateCheck check);

    @POST("/v3/phiziodevice/insert-health-status")
    Call<Boolean> sendHealthStatusOfDevice(@Body HealthData data);

    @POST("/v3/phiziodevice/update-device-location")
    Call<Boolean> sendDeviceLocationUpdate(@Body DeviceLocationStatus data);

    @POST("/v3/phiziodevice/insert-or-update-device")
    Call<Boolean> sendDeviceDetailsToTheServer(@Body DeviceDetailsData data);

    @POST("/v3/phiziodevice/update-device-email-used")
    Call<Boolean> sendEmailUsedWithDevice(@Body PhizioEmailData data);

    @POST("/v3/phiziodevice/get-device-status")
    Call<DeviceDeactivationStatusResponse> getDeviceStatus(@Body DeviceDeactivationStatus status);

    @POST("/v3/phiziomisc/device-mobile-token")
    Call<Boolean> sendMobileTokenToTheServer(@Body MobileToken token);

    @POST("/v3/phiziomisc/scheduled-session-not-saved")
    Call<Boolean> sendSceduledSessionNotSaved(@Body SceduledSessionNotSaved sceduledSessionNotSaved);

    @POST("/v3/phiziouser/delete-phiziouser")
    Call<String> deletePhiziouser(@Body DeletePhiziouserData data);

    @POST("/api/get-warranty-details")
    Call<String> warrantyDetails(@Body WarrantyData data);

    @POST("/api/get-serial-number")
    Call<String> serialnumber(@Body SerialData data);


}
