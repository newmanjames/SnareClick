import { trackLink } from "@/api/linkService";
import ClickTable from "@/components/ui/ClickTable";
import {
    Table,
    TableBody,
    TableCell,
    TableRow
} from "@/components/ui/table";
import { H1, H2 } from "@/components/ui/Typography";
import { Link } from "@/interfaces/Link";
import { useEffect, useState } from "react";
import { useParams } from "react-router";
import NotFound from "./errors/NotFound";
import Skeleton from 'react-loading-skeleton'
import 'react-loading-skeleton/dist/skeleton.css'

export default function Track() {
    const { id } = useParams();
    const [link, setLink] = useState<Link | null>(null);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState(false);

    useEffect(() => {
        trackLink(id)
            .then((link) => {
                setLink(link);
                setLoading(false);
            })
            .catch((err) => {
                setError(true);
                console.log("Error:", err);
                setLoading(false);
            })
    }, [id]);

    if (error) {
        return <NotFound />
    }

    if (loading || !link) {
        return (
            <div className="w-full max-w-7xl mx-auto p-8 flex flex-col space-y-8">
                {/* Logo */}
                <div className="flex justify-center text-blue-500">
                    <a href="/">
                        <H1>SnareClick</H1>
                    </a>
                </div>
                <div>
                    <div className="pb-6">
                        <H2>Track</H2>


                        <Table className="text-md">
                            <TableBody>
                                <TableRow>
                                    <TableCell className="w-1/5">Original Link</TableCell>
                                    <TableCell>
                                        <Skeleton width={172} />
                                    </TableCell>
                                </TableRow>
                                <TableRow>
                                    <TableCell>Created Link</TableCell>
                                    <TableCell>
                                        <Skeleton width={230} />
                                    </TableCell>
                                </TableRow>
                                <TableRow>
                                    <TableCell>Tracking Code</TableCell>
                                    <TableCell>
                                        <Skeleton width={75} />
                                    </TableCell>
                                </TableRow>
                            </TableBody>
                        </Table>
                    </div>

                    <div>
                        <H2>Clicks</H2>
                        <ClickTable clicks={[]} />
                    </div>
                </div>
            </div>
        );
    }


    return (
        <div className="w-full max-w-7xl mx-auto p-8 flex flex-col space-y-8">
            {/* Logo */}
            <div className="flex justify-center text-blue-500">
                <a href="/">
                    <H1>SnareClick</H1>
                </a>
            </div>
            <div>
                <div className="pb-6">
                    <H2>Track</H2>

                    <Table className="text-md">
                        <TableBody>
                            <TableRow>
                                <TableCell className="w-1/5">Original Link</TableCell>
                                <TableCell>
                                    <a href={link.originalLink} className="hover:underline">
                                        {link.originalLink}
                                    </a>
                                </TableCell>
                            </TableRow>
                            <TableRow>
                                <TableCell>Created Link</TableCell>
                                <TableCell>
                                    <a href={link.createdLink} className="hover:underline">
                                        {link.createdLink}
                                    </a>
                                </TableCell>
                            </TableRow>
                            <TableRow>
                                <TableCell>Tracking Code</TableCell>
                                <TableCell>{link.id}</TableCell>
                            </TableRow>
                        </TableBody>
                    </Table>
                </div>

                <div>
                    <H2>Clicks</H2>
                    <ClickTable clicks={link.clicks} />
                </div>
            </div>
        </div>
    );
}
