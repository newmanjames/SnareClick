
import { z } from "zod"

import { zodResolver } from "@hookform/resolvers/zod"
import { useForm } from "react-hook-form"

import { Button } from "@/components/ui/button"
import {
    Form,
    FormControl,
    FormDescription,
    FormField,
    FormItem,
    FormLabel,
    FormMessage,
} from "@/components/ui/form"
import { Input } from "@/components/ui/input"
import { useNavigate } from "react-router"

const formSchema = z.object({
    trackingCode: z.string().length(8, "Tracking code must be exactly 8 characters long."),
})


export default function CreateLinkForm() {
    const navigate = useNavigate();
    // form definition
    const form = useForm<z.infer<typeof formSchema>>({
        resolver: zodResolver(formSchema),
        defaultValues: {
            trackingCode: "",
        },
    })

    // submit handler (already type safe and validated)
    function onSubmit(values: z.infer<typeof formSchema>) {
        navigate(`/track/${values.trackingCode}`);
    }

    return (
        <>
            <Form {...form}>
                <form onSubmit={form.handleSubmit(onSubmit)} className="space-y-4">
                    <FormField
                        control={form.control}
                        name="trackingCode"
                        render={({ field }) => (
                            <FormItem>
                                <FormLabel>Tracking Code</FormLabel>
                                <FormControl>
                                    <Input placeholder="Ex. A1B2C3D4" {...field} />
                                </FormControl>
                                <FormDescription>
                                    This is your link's 8-digit tracking code.
                                </FormDescription>
                                <FormMessage />
                            </FormItem>
                        )}
                    />
                    <Button variant="outline" type="submit">Track Link</Button>
                </form>
            </Form>
        </>
    )
}