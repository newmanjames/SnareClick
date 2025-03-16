import {
    Table,
    TableBody,
    TableCaption,
    TableCell,
    TableHead,
    TableHeader,
    TableRow,
} from "@/components/ui/table"

interface Click {
    createdAt: string;
    ipAddress: string;
    location: string | null;
    userAgent: string;
}


interface ClicksProps {
    clicks: Click[];
}


export default function ClickTable({ clicks }: ClicksProps) {
    return (
        <Table>
            <TableHeader>
                <TableRow>
                    <TableHead>Date</TableHead>
                    <TableHead>IP Address</TableHead>
                    <TableHead>Location</TableHead>
                    <TableHead>User Agent</TableHead>
                </TableRow>
            </TableHeader>
            <TableBody>
                {clicks.map((click) => (
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