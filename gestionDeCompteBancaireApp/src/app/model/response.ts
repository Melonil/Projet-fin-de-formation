export interface Response {
    timestamp: Date;
    statusCode: number;
    status: string;
    reason: string;
    message: string;
    developerMessage: string;
    data: {dataList?: any[]; data?: any};
}