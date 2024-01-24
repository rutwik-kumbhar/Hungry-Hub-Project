export interface userSignUp{
    firstName: string;
    lastName: string;
    email: string;
    mobileNumber: string;
    role : string
}

export interface UserSignIn{
    email: string;
    password: string;
}

 export interface LoginResponse{
   token:string;
   message:string
}