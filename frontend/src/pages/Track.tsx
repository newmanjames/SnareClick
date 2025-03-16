import {
    Table,
    TableBody,
    TableCaption,
    TableCell,
    TableHead,
    TableHeader,
    TableRow,
} from "@/components/ui/table"
import { H1, H2, H3 } from "@/components/ui/Typography"
import ClickTable from "@/components/ui/ClickTable"


export default function Track() {

    const link = {
        "id": "YzRjYTc5",
        "originalLink": "https://www.google.com",
        "createdLink": "http://megatron:5173/YzRjYTc5",
        "clicks": [
            {
                "createdAt": "2025-03-16T04:10:07.564+00:00",
                "ipAddress": "100.96.57.91",
                "location": "Jacksonville, Florida, USA",
                "userAgent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:136.0) Gecko/20100101 Firefox/136.0"
            },
            {
                "createdAt": "2025-03-16T04:10:20.636+00:00",
                "ipAddress": "100.96.57.91",
                "location": null,
                "userAgent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:136.0) Gecko/20100101 Firefox/136.0"
            },
            {
                "createdAt": "2025-03-16T04:11:08.559+00:00",
                "ipAddress": "100.65.182.21",
                "location": null,
                "userAgent": "Mozilla/5.0 (iPhone; CPU iPhone OS 18_3_2 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/18.3.1 Mobile/15E148 Safari/604.1"
            },
            {
                "createdAt": "2025-03-16T04:13:11.775+00:00",
                "ipAddress": "100.65.182.21",
                "location": null,
                "userAgent": "Mozilla/5.0 (iPhone; CPU iPhone OS 18_3_2 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/18.3.1 Mobile/15E148 Safari/604.1"
            },
            {
                "createdAt": "2025-03-16T04:13:52.793+00:00",
                "ipAddress": "100.96.57.91",
                "location": null,
                "userAgent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:136.0) Gecko/20100101 Firefox/136.0"
            },
            {
                "createdAt": "2025-03-16T04:14:44.988+00:00",
                "ipAddress": "100.96.57.91",
                "location": null,
                "userAgent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:136.0) Gecko/20100101 Firefox/136.0"
            },
            {
                "createdAt": "2025-03-16T04:14:57.393+00:00",
                "ipAddress": "100.96.57.91",
                "location": null,
                "userAgent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:136.0) Gecko/20100101 Firefox/136.0"
            },
            {
                "createdAt": "2025-03-16T04:15:01.614+00:00",
                "ipAddress": "100.96.57.91",
                "location": null,
                "userAgent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:136.0) Gecko/20100101 Firefox/136.0"
            },
            {
                "createdAt": "2025-03-16T04:15:05.644+00:00",
                "ipAddress": "100.96.57.91",
                "location": null,
                "userAgent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:136.0) Gecko/20100101 Firefox/136.0"
            },
            {
                "createdAt": "2025-03-16T04:15:14.544+00:00",
                "ipAddress": "100.96.57.91",
                "location": null,
                "userAgent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:136.0) Gecko/20100101 Firefox/136.0"
            },
            {
                "createdAt": "2025-03-16T04:15:19.969+00:00",
                "ipAddress": "100.96.57.91",
                "location": null,
                "userAgent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:136.0) Gecko/20100101 Firefox/136.0"
            },
            {
                "createdAt": "2025-03-16T04:17:20.067+00:00",
                "ipAddress": "100.96.57.91",
                "location": null,
                "userAgent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:136.0) Gecko/20100101 Firefox/136.0"
            },
            {
                "createdAt": "2025-03-16T15:49:00.806+00:00",
                "ipAddress": "100.96.57.91",
                "location": null,
                "userAgent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:136.0) Gecko/20100101 Firefox/136.0"
            },
            {
                "createdAt": "2025-03-16T15:49:34.385+00:00",
                "ipAddress": "100.96.57.91",
                "location": null,
                "userAgent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:136.0) Gecko/20100101 Firefox/136.0"
            },
            {
                "createdAt": "2025-03-16T15:50:59.519+00:00",
                "ipAddress": "100.96.57.91",
                "location": null,
                "userAgent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:136.0) Gecko/20100101 Firefox/136.0"
            },
            {
                "createdAt": "2025-03-16T15:51:10.793+00:00",
                "ipAddress": "100.96.57.91",
                "location": null,
                "userAgent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:136.0) Gecko/20100101 Firefox/136.0"
            }
        ]
    }

    return <>
        <div className="w-full max-w-7xl mx-auto p-8 flex flex-col space-y-8">
            {/* Logo */}
            <div className="flex justify-center text-blue-500">
                <a href="/">
                    <H1>SnareClick</H1>
                </a>
            </div>

            <div className="pb-6">
                <H2>Track</H2>

                <Table className="text-md">
                    <TableBody>
                        <TableRow>
                            <TableCell className="w-1/5">Original Link</TableCell>
                            <TableCell>
                                <a href={link.originalLink}
                                    className="hover:underline">
                                    {link.originalLink}
                                </a>
                            </TableCell>
                        </TableRow>
                        <TableRow>
                            <TableCell>Created Link</TableCell>
                            <TableCell>
                                <a href={link.createdLink}
                                    className="hover:underline">
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
    </>
}