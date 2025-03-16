
import { z } from "zod"

import { P } from "@/components/ui/Typography"
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

const formSchema = z.object({
    redirectURL: z.string().url("Please enter a valid URL"),
})


export default function CreateLinkForm() {
    // form definition
    const form = useForm<z.infer<typeof formSchema>>({
        resolver: zodResolver(formSchema),
        defaultValues: {
            redirectURL: "",
        },
    })

    // submit handler
    function onSubmit(values: z.infer<typeof formSchema>) {
        // Do something with the form values.
        // ✅ This will be type-safe and validated.
        console.log(values)
    }

    return (
        <>
            <Form {...form}>
                <form onSubmit={form.handleSubmit(onSubmit)} className="space-y-4">
                    <FormField
                        control={form.control}
                        name="redirectURL"
                        render={({ field }) => (
                            <FormItem>
                                <FormLabel>Redirect URL</FormLabel>
                                <FormControl>
                                    <Input placeholder="Ex. https://snareclick.com" {...field} />
                                </FormControl>
                                <FormDescription>
                                    <P>This is the destination your link will redirect to.</P>
                                </FormDescription>
                                <FormMessage />
                            </FormItem>
                        )}
                    />
                    <Button variant="outline" type="submit">Create Link</Button>
                </form>
            </Form>
        </>
    )
}