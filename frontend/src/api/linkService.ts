import axiosInstance from "./axiosInstance";

const createLink = async (originalLink: string) => {
    const response = await axiosInstance.post("/create", { originalLink });
    return response.data;
};

const trackLink = async (trackingCode: string) => {
    const response = await axiosInstance.get(`/track/${trackingCode}`);
    return response.data
};

export { createLink, trackLink };