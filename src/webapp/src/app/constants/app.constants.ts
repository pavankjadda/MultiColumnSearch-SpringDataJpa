//API URLS
export const EMPLOYEE_API_URL = "/api/v1/employee";

//System settings
export enum SystemConfig
{
  SYSTEM_TIME_ZONE = 'America/New_York',
  SYSTEM_LOCALE = 'en-US',
  SYSTEM_DATE_FORMAT = 'MM/dd/yyyy',
  SYSTEM_DATE_TIME_FORMAT = 'MM/dd/yyyy hh:mm:ss a',
  SYSTEM_SPINNER_TYPE = 'ball-clip-rotate',

  //Default Cookie expiration is 60 minutes(Server sends usually cookie with 60 minutes timeout)
  SYSTEM_COOKIE_TIMEOUT_MINUTES=60,
  SYSTEM_COOKIE_TIMEOUT_MILLI_SECONDS=3600000,
}
