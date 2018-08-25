import { Theatre } from './theatre';

export class ShowDetails {
    theatre: Theatre[];
    showId: number;
    price: number;
    seatsRemaining: number;
    startDate: Date;
    endDate: Date;
}
