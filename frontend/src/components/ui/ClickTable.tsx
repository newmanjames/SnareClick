import {
    Table,
    TableBody,
    TableCaption,
    TableCell,
    TableHead,
    TableHeader,
    TableRow
} from "@/components/ui/table"

import { Clicks } from "@/interfaces/Clicks"


export default function ClickTable({ clicks }: Clicks) {
    return (
        <Table>
            {clicks.length === 0 && <TableCaption>No activity yet. Check back later!</TableCaption>}
            <TableHeader>
                <TableRow>
                    <TableHead>Date</TableHead>
                    <TableHead>IP Address</TableHead>
                    <TableHead>Location</TableHead>
                    <TableHead>User Agent</TableHead>
                </TableRow>
            </TableHeader>
            <TableBody>
                {
                    clicks.map((click) => (
                        <TableRow>
                            <TableCell>{click.createdAt}</TableCell>
                            <TableCell>{click.ipAddress}</TableCell>
                            <TableCell>{click.location}</TableCell>
                            <TableCell className="w-1/2 whitespace-normal" >{click.userAgent}</TableCell>
                        </TableRow>
                    ))}

            </TableBody>
        </Table>

    )
}