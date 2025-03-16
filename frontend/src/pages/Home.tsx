import CreateLinkForm from "@/components/ui/CreateLinkForm";
import TrackLinkForm from "@/components/ui/TrackLinkForm";
import { H1, H2, P } from "@/components/ui/Typography";

export default function Home() {
    return (
        <div className="w-full max-w-4xl mx-auto p-8 flex flex-col space-y-8">
            {/* Logo */}
            <div className="flex justify-center text-blue-500">
                <a href="/">
                    <H1>SnareClick</H1>
                </a>
            </div>

            {/* What is SnareClick? */}
            <div className="py-6  space-y-6">
                <H2>What is SnareClick?</H2>
                <P>
                    SnareClick allows you to easily generate a link that redirects to any URL you choose.
                    Simply input the destination URL, and we will create a new link for you that will redirect
                    visitors to your chosen page while capturing important data like IP address and location.
                </P>
                <P>
                    While useful for testing, marketing campaigns, or gathering analytics, use SnareClick
                    responsibly and always ensure you're in compliance with all privacy and legal requirements.
                </P>
            </div>

            {/* Create a URL */}
            <div className="py-6  space-y-6">
                <H2>Create a Link</H2>
                <CreateLinkForm />
            </div>
            {/* Track a URL */}
            <div className="py-6 space-y-6">
                <H2>Track a Link</H2>
                <TrackLinkForm />
            </div>
        </div>
    );
}