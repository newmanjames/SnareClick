import { Click } from "./Click";


export interface Link {
    originalLink: string;
    createdLink: string;
    id: string;
    clicks: Click[];
}
