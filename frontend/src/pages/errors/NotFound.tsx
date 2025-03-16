import { Button } from "@/components/ui/button"
import { H1, P } from "@/components/ui/Typography"
import { useNavigate } from "react-router"

export default function NotFound() {
    const navigate = useNavigate()

    return (
        <div className="flex flex-col items-center justify-center min-h-screen  text-center px-4">
            <div className="max-w-md">
                <H1 >404</H1>
                <P>
                    Oops! The page you are looking for does not exist.
                </P>
                <Button
                    variant="outline"
                    className="mt-6"
                    onClick={() => navigate("/")}>
                    Go Home
                </Button>
            </div>
        </div>
    )
}
