import { DatePipe } from "@angular/common";

export class Guest {
    guestName!: string;
    guestAge!:number;
    guestContactNo!:number;
    guestEmailId!:string;
    guestAddress!:string;
    guestpassword!:string;
    role!:string;
    checkInDate!:Date;
    checkOutDate!:Date;
    numberofadults!:number;
    numberofchild!:number;
}
