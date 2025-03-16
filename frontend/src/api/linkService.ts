import axiosInstance from "./axiosInstance";

const createLink = async (originalURL: string) => {
    const response = await axiosInstance.post("/create", { originalURL });
    return response.data;
};

const trackLink = async (trackingCode: string) => {
    const response = await axiosInstance.get(`/track/${trackingCode}`);
    return response.data;
};

export { createLink, trackLink };