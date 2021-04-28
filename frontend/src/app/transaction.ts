import { User } from './user';
export interface Transaction {
    transactionID: number;
	date: string;
	subtotal: number;
	discounts: number;
	tax: number;
	loyalty: User;
}
